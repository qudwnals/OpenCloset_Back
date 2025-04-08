package DevFlow.OpenCloset_Back.Login.Jwt_Util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret"; // 최소 256비트 (32자 이상)

    // 토큰 유효 시간 설정 (예: 1일)
    private static final long EXPIRATION_TIME = 86400000L; // 24시간 (1 * 60 * 60 * 1000)

    // static 메서드로 설정
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)         // 사용자 정보 (username)
                .setIssuedAt(now)             // 발급 시간
                .setExpiration(expiryDate)    // 만료 시간
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256) // 서명
                .compact();
    }
}