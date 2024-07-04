package in.ineuron.securityconfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {
	
	@Autowired
	public void configuration(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("sachin").password("{noop}tendulkar").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}mumbai").roles("MANAGER");
	}
	
	@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/offers").authenticated()
                .requestMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
                .requestMatchers("/loanApprove").hasRole("MANAGER") 
                .anyRequest().authenticated()
                .and().formLogin().and().rememberMe()
                .and().logout()
                .and().exceptionHandling().accessDeniedPage("/denied")
                .and().sessionManagement().maximumSessions(3).maxSessionsPreventsLogin(true);// Use antMatchers() instead of requestMatchers()
        return http.build();
    }

}
