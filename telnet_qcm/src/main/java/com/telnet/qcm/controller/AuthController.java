package com.telnet.qcm.controller;


import com.telnet.qcm.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    MyProperties myProperties;

    @GetMapping("/expirationPeriodCookies")
    public double getExpirationPeriodCookies() {
        return myProperties.getExpirationPeriodCookies();
    }

}
