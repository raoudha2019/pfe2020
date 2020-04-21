package com.telnet.qcm.configuration;

import com.telnet.qcm.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyCrosFilter myCorsFilter;

    @Autowired
    private DataSource dataSource;

    @Autowired
    MyProperties myProperties;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override

    protected void configure(HttpSecurity http) throws Exception {
        //Permission**********

        http.csrf().disable().authorizeRequests().antMatchers("/Utilisateur/**","/auth/**").permitAll()
                .antMatchers("/login", "/*.jpg", "/*.png", "/*.js", "/*.css", "/*.woff2", "/assets/**", "/*.ico")
                .anonymous().anyRequest().authenticated().and()
                // We filter the api/login requests
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager() , myProperties.getTokenExpirationPeriode()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        // CORS
        http.addFilterBefore(myCorsFilter, ChannelProcessingFilter.class);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username,password,active from user where username=?")
                .authoritiesByUsernameQuery(
                        "select u.username, r.role_name from user u join role r on u.role_id = r.id where username = ?");
    }
}