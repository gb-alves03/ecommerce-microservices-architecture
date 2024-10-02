package br.com.alves.ecommerce.authentication.config.security;

import br.com.alves.ecommerce.authentication.utils.AuthenticationEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserAuthenticationFilter userAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(AuthenticationEndpoints.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll();
                    authorize.requestMatchers(AuthenticationEndpoints.ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated();
                    authorize.requestMatchers(AuthenticationEndpoints.ENDPOINTS_ADMIN).hasRole("ADMIN");
                    authorize.requestMatchers(AuthenticationEndpoints.ENDPOINTS_CUSTOMER).hasRole("CUSTOMER");
                    authorize.anyRequest().denyAll();
                })
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
