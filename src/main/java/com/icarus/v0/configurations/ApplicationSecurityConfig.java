package com.icarus.v0.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();

		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/api/v1/auth").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/v1/states/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/v1/states/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/v1/states/**").hasAuthority("ADMIN").antMatchers("/api/v1/states/**")
				.permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/countries/**")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.POST, "/api/v1/countries/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/v1/countries/**").hasAuthority("ADMIN")
				.antMatchers("/api/v1/countries/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/v1/city/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/v1/city/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/v1/city/**").hasAuthority("ADMIN").antMatchers("/api/v1/city/**")
				.permitAll().antMatchers(HttpMethod.DELETE, "/api/v1/dataPoints/**")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.POST, "/api/v1/dataPoints/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/v1/dataPoints/**").hasAuthority("ADMIN")
				.antMatchers("/api/v1/dataPoints/**").hasAnyAuthority("ADMIN", "CONSULTANT")
				.antMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/v1/users/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/v1/users/**").hasAuthority("ADMIN").antMatchers("/api/v1/users/**")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
