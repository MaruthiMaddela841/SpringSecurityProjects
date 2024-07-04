package in.ineuron.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	static {
		System.out.println("SecurityConfigApp.enclosing_method()");
	}
	
	
	
	public SecurityConfigApp() {
		System.out.println("SecurityConfigApp.SecurityConfigApp()");
	}



	@Bean
	public SecurityFilterChain userDefinedFilter(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfigApp.userDefinedFilter()"); 
		//System.out.println("Implementation class is::"+http.build().getClass().getName());
		http
          .authorizeHttpRequests(authorizeRequests ->
              authorizeRequests
                  .requestMatchers("/bank/","/bank/about","/bank/login").permitAll()
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .anyRequest().authenticated()
          )
          .formLogin();  // Enable form based login
		return http.build();
	}

}
