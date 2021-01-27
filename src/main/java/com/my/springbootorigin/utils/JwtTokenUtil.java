package com.my.springbootorigin.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtTokenUtil {

    /** 签名秘钥 */
    private static final String SECRET = "springbootOrigin";

    /** 签发地 */
    private static final String issuer  = "com.my.springboot";

    /** 过期时间 */
    private static final long ttlMillis = 1000*60*60;

    /**
     * 生成token
     * @param id 一般传入userName
     */
    public static String createJwtToken(String id) {
        return createJwtToken(id, issuer, "client", ttlMillis);
    }

    /**
     * 生成Token
     * @param id        编号
     * @param issuer    该JWT的签发者，是否使用是可选的
     * @param subject   该JWT所面向的用户，是否使用是可选的；
     * @param ttlMillis 签发时间 （有效时间，过期会报错）
     * @return token String
     */
    public static String createJwtToken(String id, String issuer, String subject, long ttlMillis) {
        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 通过秘钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        String str=signatureAlgorithm.getJcaName();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, str);

        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            //过期时间
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();

    }

    /**
     * Token解析方法
     * @param jwt Token
     * @return
     */
    public static Claims parseJWT(String jwt) {
        // 如果token过期，那么它将抛出异常
        Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                    .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 是否已过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return parseJWT(token).getExpiration().before(new Date());
    }

    /**
     * 从HttpServletRequest中解析出token
     * @param request
     * @return
     */
    public static String parseToken(HttpServletRequest request) {
        String accessToken = request.getHeader("X-Token");
        if (!StringUtils.hasLength(accessToken)) {
            accessToken = request.getHeader("token");
        }
        if (!StringUtils.hasLength(accessToken)) {
            accessToken = request.getParameter("token");
        }
        return accessToken;
    }

    public static void main(String[] args) {

        String token = JwtTokenUtil.createJwtToken("2");

        System.out.println(token);

        Claims claims = JwtTokenUtil.parseJWT(token);

        if (claims == null) return;
        System.out.println("11111");
        System.out.println(claims);
        System.out.println(claims.getId());
        System.out.println(isExpiration(token));

    }
}
