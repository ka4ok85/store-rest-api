package com.example.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.CustomUserDetailsAuthenticationProvider;
import com.example.security.JwtAuthenticationEntryPoint;
import com.example.security.JwtAuthenticationTokenFilter;
import com.example.security.WebAuthenticationDetailsSourceImplementation;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private CustomUserDetailsAuthenticationProvider customUserDetailsAuthenticationProvider;
	
	@Autowired
	private WebAuthenticationDetailsSourceImplementation webAuthenticationDetailsSourceImplementation;
	
	@Resource
    private UserDetailsService userDetailsService;
	
	@Bean
	public CustomUserDetailsAuthenticationProvider myAuthProvider() throws Exception {
		CustomUserDetailsAuthenticationProvider provider = new CustomUserDetailsAuthenticationProvider();
	    provider.setPasswordEncoder(passwordEncoder());
	    provider.setUserDetailsService(userDetailsService);

	    return provider; 
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        authenticationTokenFilter.setAuthenticationDetailsSource(webAuthenticationDetailsSourceImplementation);

        return authenticationTokenFilter;
    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.authenticationProvider(customUserDetailsAuthenticationProvider);
	} 
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable() // we don't need CSRF because our token is invulnerable
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and() // redirect request w/o authentication to the custom handler
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // don't create session
                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(  // allow anonymous resource requests
                        HttpMethod.GET,
                        "/",
                        "/v1/stores" // probably we should allow only getAllStores request only. TODO
                ).permitAll()
                .antMatchers("/v1/auth/**").permitAll() // TODO only POST
                .anyRequest().authenticated()
                .and()  
                .formLogin()
                .authenticationDetailsSource(webAuthenticationDetailsSourceImplementation)
                .permitAll();

        // Custom JWT based security filter
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().cacheControl();
	}
}
