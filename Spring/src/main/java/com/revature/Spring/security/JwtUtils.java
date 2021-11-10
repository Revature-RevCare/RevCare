package com.revature.Spring.security;


import com.revature.Spring.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Date;

/**
 * Component class JwtUtils. Contains a Logger instance variable named logger set to a logger
 * generated in the LoggerFactory. Contains a private string named jwtSecret and int jwtEpirationMs set to
 * 89000000.
 *
 * <b>Methods</b>
 *  <ul>
 *      <li>generateJwtToken - returns a string value for a Java Web Token authentication</li>
 *      <li>getUserNameFromJwtToken - returns a string value for the username</li>
 *      <li>validateJwtToken - returns a boolean value for the token validation status</li>
 *  </ul>
 */
@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);


    @Value("${spring.app.jwt.secret}")
    private String jwtSecret;

//    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs = 8900000;

    /**
     * Method generateJwtToken first sets an instance of UserDetailsImpl named userPrincipal to
     * the principal of the passed-in authentication parameter. It then uses the Jwts.builder to
     * create the autentication string for return.
     *
     * @param authentication An instance of an Authentication object.
     * @return A String containing the Java Web Token authentication details.
     */
    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * The getUserNameFromJwtToken method takes in an authentication token as a String value and returns the
     * tokens username as a String.
     * @param token A String containing the token in a string format.
     * @return A String containing the username within the authentication Java Web Token.
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * The validateJWTToken method takes in the authentication token as a String value and returns
     * the validations success or failure boolean value.
     * @param authToken A String containing the authentication Java Web Token.
     * @return A boolean representing the success or failure of the authentication validation.
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
