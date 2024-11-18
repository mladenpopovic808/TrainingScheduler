package rs.ognjen_uros.spring_zakazivanje_treninga.secutiry.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.User;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.VerificationToken;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.TokenRepository;
import rs.ognjen_uros.spring_zakazivanje_treninga.secutiry.service.TokenService;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Value("${oauth.jwt.secret}")
    private String jwtSecret;

    private TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String generate(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(claims.get("email").toString())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public Claims parseToken(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

    @Override
    public VerificationToken findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public VerificationToken findByUser(User user) {
        return tokenRepository.findByUser(user);
    }

    @Override
    public void save(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        System.out.println("USAO");
        verificationToken.setExpireDate(calculateExpiryDate(24*60));
        tokenRepository.save(verificationToken);
    }

    @Override
    public Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Timestamp(cal.getTime().getTime());
    }
}
