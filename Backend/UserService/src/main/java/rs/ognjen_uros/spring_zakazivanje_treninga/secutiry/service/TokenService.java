package rs.ognjen_uros.spring_zakazivanje_treninga.secutiry.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.User;
import rs.ognjen_uros.spring_zakazivanje_treninga.domain.VerificationToken;
import rs.ognjen_uros.spring_zakazivanje_treninga.repository.TokenRepository;

import java.sql.Timestamp;

public interface TokenService {

    String generate(Claims claims);

    Claims parseToken(String jwt);

    Claims extractAllClaims(String token);


    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);

    void save(User user, String token);


    Timestamp calculateExpiryDate(int expiryTimeInMinutes);

}
