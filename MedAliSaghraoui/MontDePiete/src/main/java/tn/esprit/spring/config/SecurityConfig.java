package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.esprit.spring.filters.JwtRequestFilter;
import tn.esprit.spring.service.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/authenticate");
	}
	@Bean
	public UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("ADMIN").build());
		return manager;
	}
	
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*httpSecurity.csrf().ignoringAntMatchers("/authenticate").and()
				.authorizeRequests().antMatchers(HttpMethod.POST,"/authenticate").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);*/
        httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().antMatchers("/").permitAll();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
    
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{

		auth.userDetailsService(myUserDetailsService).passwordEncoder(encodePWD());
	}
	

	
	public PasswordEncoder getencodePWD()
	{
		return new PasswordEncoder(){

			@Override
			public String encode(CharSequence c) {
				
				return c.toString();
			}

			@Override
			public boolean matches(CharSequence c, String a) {
				
				return true;
			}
			
		};
	}

	
	@Bean
	public BCryptPasswordEncoder encodePWD()
	{
		return new BCryptPasswordEncoder();
	}
}

