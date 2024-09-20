package com.ipartek.formacion.iparshopspring.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	// AUTENTICACIÓN
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails javier =
			 User.withDefaultPasswordEncoder()
				.username("javier@email.net")
				.password("javier")
				.roles("ADMIN")
				.build();
	
		UserDetails pepe =
				 User.withDefaultPasswordEncoder()
					.username("pepe@email.net")
					.password("pepe")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(javier, pepe);
	}

	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/usuario/**").hasRole("USER")
				.anyRequest().permitAll() //.authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
}