package pl.chmiel.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.chmiel.library.security.CustomUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/bookgui", "/addbook", "/deletebook", "/updatebook", "/adduser").hasRole("ADMIN")
            .antMatchers("/showallbooks", "/showuserbooks", "/usergui").hasAnyRole("ADMIN", "USER")
            .anyRequest().permitAll()
            .and()
            .formLogin().permitAll();
    http.csrf().disable().headers().disable();

  }

  @Bean
  public PasswordEncoder passwordencoder() {
    return new BCryptPasswordEncoder();
  }






}