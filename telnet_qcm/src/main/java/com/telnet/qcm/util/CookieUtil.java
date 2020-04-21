package com.telnet.qcm.util;

/*
@Component
public class CookieUtil {
    @Value("${authentication-test.auth.accessTokenCookieName}")
    private String accessTokenCookieName;

    @Value("${authentication-test.auth.refreshTokenCookieName}")
    private String refreshTokenCookieName;

    public HttpCookie createAccessTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityCipher.encrypt(token);
        return ResponseCookie.from(accessTokenCookieName, encryptedToken)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createRefreshTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityCipher.encrypt(token);
        return ResponseCookie.from(refreshTokenCookieName, encryptedToken)
                .maxAge(duration)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from(accessTokenCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }

}*/

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties

public class CookieUtil {


    double expirationPeriodCookies;

    public double getExpirationPeriodCookies() {
        return expirationPeriodCookies;
    }

    public void setExpirationPeriodCookies(double expirationPeriodCookies) {
        this.expirationPeriodCookies = expirationPeriodCookies;
    }
}
