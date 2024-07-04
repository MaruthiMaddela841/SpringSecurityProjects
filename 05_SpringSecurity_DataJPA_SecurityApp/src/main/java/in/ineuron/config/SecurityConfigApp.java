package in.ineuron.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.ineuron.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder)
		.and()
		.jdbcAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(datasource)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.requestMatchers("/bank/").permitAll()
		.requestMatchers("/bank/offers").authenticated()
		.requestMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")
		.requestMatchers("/bank/loanApprove").hasAuthority("MANAGER")
		.requestMatchers("/user/register","/user/showLogin").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.defaultSuccessUrl("/bank/",true)
		.loginPage("/user/showLogin")
		.loginProcessingUrl("/login")
		.failureUrl("/user/showLogin?error")
		.and().rememberMe()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.logoutSuccessUrl("/user/showLogin?logout")
		.and().exceptionHandling()
		.accessDeniedPage("/denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		return http.build();
	}

}
