package com.example.mybatisredis.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 1.生成token
 * 2.获取签名信息
 * 3.验证token有效性
 */
public class JwtUtils {

    // 令牌过期时间（这里设置为24小时）
    private static final long EXPIRATION_TIME = 20;

    // 密钥（实际应用中应该从安全的地方获取，且保持足够复杂度）
    private static final String STR_KEY="h6Ml8PoXk5vR2tS9qYw3uZ1x7cA4bD0eF2gH5jK8nM";

    private static final  SecretKey SECRET_KEY;

    static {
        byte[] keyBytes = STR_KEY.getBytes();
        SECRET_KEY=Keys.hmacShaKeyFor(keyBytes);

    }

    /**
     * 生成包含自定义声明的JWT令牌
     * @param claims 自定义声明
     * @return 生成的令牌
     */
    public static String generateToken(Map<String, Object> claims) {


        Date now =new Date();

        Date expireTime=new Date(now.getTime()+EXPIRATION_TIME*60*1000);

        claims.put("issuedTime",now);

        claims.put("expireTime",expireTime);


        return Jwts.builder()
                .setClaims(claims)  // 设置自定义声明
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)  // 设置签名算法和密钥
                .compact();  // 生成令牌字符串
    }

    /**
     * 从令牌中获取指定的声明
     * @param token 令牌
     * @return 声明值
     */
    public Object extractClaim(String token, String claimKey) {
        final Claims claims = extractAllClaims(token);
        return claims.get(claimKey);
    }

    /**
     * 从令牌中获取所有声明
     * @param token 令牌
     * @return 所有声明
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)  // 设置签名密钥
                .build()
                .parseClaimsJws(token)  // 解析令牌
                .getBody();  // 获取声明主体
    }

    /**
     * 验证令牌是否有效
     * @param token 令牌
     * @param username 用户名
     * @return 如果有效返回true，否则返回false
     */
    public boolean validateToken(String token, String username) {
        // 1. 先校验令牌的基础合法性（签名、格式、未过期）
        if (!validateToken(token)) {
            return false;
        }

        // 2. 提取用户名并校验（避免空指针和类型转换异常）
        Object usernameObj = extractClaim(token, "username");
        if (!(usernameObj instanceof String)) {
            return false; // 用户名类型不正确
        }
        String extractedUsername = (String) usernameObj;

        // 3. 对比用户名
        return extractedUsername.equals(username);
    }

    /**
     * 验证令牌是否有效（不验证用户名）
     * @param token 令牌
     * @return 如果有效返回true，否则返回false
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {

        LocalDateTime expireTime=(LocalDateTime) extractClaim(token,"expireTime");
        return expireTime.isBefore(LocalDateTime.now());
    }

}
