package com.telnet.qcm.util;
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
