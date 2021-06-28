package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try{
			http.authorizeRequests()
				.antMatchers("/duenomascota").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
				.antMatchers("/mascota").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
				.antMatchers("/mascota/irRegistrar").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/oferta").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_PET')or hasRole('ROLE_VET')")
				.antMatchers("/veterinario").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')or hasRole('ROLE_PET')or hasRole('ROLE_VET')")
				.antMatchers("/veterinario/irRegistrar").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_VET')")
				.antMatchers("/veterinarioconsultorio").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_VET')")
				.antMatchers("/duenomascotapetshop").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_PET')")
				.antMatchers("/mascotaconsultorio").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_VET')")
				.antMatchers("/petshop").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')or hasRole('ROLE_PET')or hasRole('ROLE_VET')")
				.antMatchers("/petshop/irRegistrar").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_PET')")
				.antMatchers("/consultorio").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')or hasRole('ROLE_PET')or hasRole('ROLE_VET')")
				.antMatchers("/consultorio/irRegistrar").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_VET')")
				.antMatchers("/welcome").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')or hasRole('ROLE_PET')or hasRole('ROLE_VET')").and()
				.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}
