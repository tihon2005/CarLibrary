package by.carlibra.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final String SECRET_KEY = "46294A404E635266556A586E327235753778214125442A472D4B615064536756";

    //генерирует JWT на основе предоставленных утверждений (claims) и деталей пользователя (userDetails)
    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    //проверяет, действителен ли токен (token), используя утверждения из userDetails, а также проверяет,
    // не истек ли срок действия токена
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractEmail(token);

        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //проверяют, истек ли срок действия токена, и извлекают дату истечения срока действия из токена.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //извлекает адрес электронной почты (или любой другой идентификатор) из утверждений токена.
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //методы позволяют извлечь все утверждения из токена.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //возвращает ключ подписи, который используется для создания и проверки JWT.
    // Ключ получается из секретного ключа приложения.
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
