package com.teluskoLearning.demo.config;


import com.teluskoLearning.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailsService);
//        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.requestMatchers("/register", "/login").permitAll().anyRequest().authenticated()).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationmanager(AuthenticationConfiguration config){
return config.getAuthenticationManager(); //We utilize this AuthenticationManager object inside login route
    }







}