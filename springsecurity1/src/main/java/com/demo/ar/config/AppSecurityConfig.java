package com.demo.ar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
		//authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		authProvider.setUserDetailsService(userDetailsService);
		return authProvider;
		
	}
	
	//@Override
	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 * { // TODO Auto-generated method stub
	 * auth.userDetailsService(userDetailsService); }
	 */
		 
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	                .antMatchers("/resources/**", "/login").permitAll()
	                .anyRequest().authenticated();
	                
	 }

	//@Override
	/*
	 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 * { // TODO Auto-generated method stub
	 * auth.inMemoryAuthentication().withUser("ss").password("ss").roles("USER").
	 * and().withUser("ss1").password("ss1").roles("ADMIN"); }
	 */
	
	//@Bean
	/*public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
	 * .antMatchers("/user").hasAnyRole("ADMIN","USER")
	 * .antMatchers("/").permitAll().and() .formLogin(); }
	 */
	
	
	 //@Override
	/*    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	                .antMatchers("/resources/**", "/login").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin().loginPage("/login").permitAll()
	                .and()
	            .logout().invalidateHttpSession(true).clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	               .logoutSuccessUrl("/logout-success") .permitAll();
	    }*/

	/*
	 * @Override
	 * 
	 * @Bean protected UserDetailsService userDetailsService() { List<UserDetails>
	 * users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("user").password("1234")
	 * .roles("USER").build()); return new InMemoryUserDetailsManager(users); }
	 */

}
