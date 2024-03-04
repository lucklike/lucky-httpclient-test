package io.github.lucklike.serverboot.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/2 21:34
 */
public class JWTUtils {

    private static final String SECRET_KEY = "__JWT__LUCKY__"; // 替换为你自己的密钥

    // 创建JWT
    public static String createJWT(String userId, String issuer, long ttlMillis) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + ttlMillis);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuer(issuer)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 解析JWT
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
