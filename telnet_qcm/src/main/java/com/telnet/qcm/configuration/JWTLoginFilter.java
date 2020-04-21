package com.telnet.qcm.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telnet.qcm.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;




public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    long tokenDelay ;

    public JWTLoginFilter(String url, AuthenticationManager authManager, long l) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        tokenDelay=l;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
       User user = new ObjectMapper()
                .readValue(req.getInputStream(), User.class);


        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        TokenAuthenticationService
                .addAuthentication(res, auth.getName() , tokenDelay);
    }
}