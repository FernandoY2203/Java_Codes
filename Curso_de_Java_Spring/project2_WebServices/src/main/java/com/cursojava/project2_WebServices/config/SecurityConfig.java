package com.cursojava.project2_WebServices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// JDBC
	
	@Autowired
	private SecurityDatabaseService securityDatabaseService;
	
	@Autowired
	private void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityDatabaseService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	
	// Em Memória
//	@Bean
//	UserDetailsService users() {
//		UserDetails user = User.builder()
//							   .username("user")
//							   .password("{noop}user123")
//							   .roles("USERS")
//							   .build();
//
//		UserDetails admin = User.builder()
//								.username("admin")
//							    .password("{noop}admin123")
//							    .roles("MANAGERS")
//							    .build();
// 
//		return new InMemoryUserDetailsManager(user, admin);
//	}	
	
	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers(HttpMethod.GET).hasAnyRole("MANAGERS", "USERS")
														   .requestMatchers(HttpMethod.DELETE).hasRole("MANAGERS")
														   .requestMatchers(HttpMethod.POST).hasRole("MANAGERS")
														   .requestMatchers(HttpMethod.PUT).hasRole("MANAGERS")
														   .anyRequest().authenticated()
								  ).httpBasic(Customizer.withDefaults()).csrf((csrf) -> csrf.disable());
	  
		return http.build();
	}

}
