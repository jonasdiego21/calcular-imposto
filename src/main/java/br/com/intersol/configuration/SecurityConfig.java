package br.com.intersol.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/proprietarios/novo").hasAuthority("CADASTRAR_PROPRIETARIO")
				.antMatchers("/imoveis/novo").hasAuthority("CADASTRAR_IMOVEL")
				.antMatchers("/usuarios/novo").hasAuthority("CADASTRAR_USUARIO")
				
				.antMatchers("/proprietarios").hasAuthority("PESQUISAR_PROPRIETARIO")
				.antMatchers("/imoveis").hasAuthority("PESQUISAR_IMOVEL")
				.antMatchers("/usuarios").hasAuthority("PESQUISAR_USUARIO")
				
				.antMatchers("/boletos").hasAuthority("GERAR_BOLETO")
				
				.antMatchers("/").hasAuthority("DASHBOARD")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
			.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.sessionManagement()
					.maximumSessions(500).expiredUrl("/login");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/css/**", "/images/**", "/js/**", "/vendor/**", "/relatorios/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
