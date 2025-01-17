package com.xproce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    // @Bean
    //SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    // Configuration to deny all the requests
    //    http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
    //This line configures form-based authentication
    //            .formLogin(Customizer.withDefaults())
    //This line configures HTTP Basic authentication
     //           .httpBasic(Customizer.withDefaults());
      //  return http.build();
    //}

    /*
    @Bean
    SecurityFilterChain defaultSecurityFilterChain( HttpSecurity http) throws Exception {
            // Configuration to permit all the requests
            http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
            return http.build();
    }
        */


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact","/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
