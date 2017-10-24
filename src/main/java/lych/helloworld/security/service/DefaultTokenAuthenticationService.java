package lych.helloworld.security.service;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lych.helloworld.model.User;
import lych.helloworld.model.UserAuthentication;
import lych.helloworld.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultTokenAuthenticationService implements TokenAuthenticationService {

    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(HttpServletRequest request) {

        final String token = request.getHeader(SecurityConstants.authHeaderName);

        final Jws<Claims> tokenData = parseToken(token);

        if (tokenData != null) {

            User user = getUserFromToken(tokenData);
            if (user != null) {

                return new UserAuthentication(user);
            }
        }

        return null;
    }

    private Jws<Claims> parseToken(final String token) {

        if (token != null) {

            try {

                return Jwts.parser().setSigningKey(SecurityConstants.secretKey).parseClaimsJws(token);
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
                    | SignatureException | IllegalArgumentException e) {

                return null;
            }
        }

        return null;
    }

    private User getUserFromToken(final Jws<Claims> tokenData) {

        try {

            return (User) userDetailsService
                    .loadUserByUsername(tokenData.getBody().get("username").toString());
        } catch (UsernameNotFoundException e) {

            throw new RuntimeException("User "
                    + tokenData.getBody().get("username").toString() + " not found");
        }
    }
}
