package ru.shcheglov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Alexey Shcheglov
 * @version dated 28.12.2018
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("test").password("test").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("ADMINISTRATOR", "USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/admin/**").hasAuthority("ADMINISTRATOR")
                    .anyRequest().authenticated()

//                .authorizeRequests()
//                .anyRequest().hasAnyAuthority("ADMINISTRATOR", "USER")
//                .antMatchers("/login", "/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .antMatchers("/**").authenticated()
//                .antMatchers("/admin/**").hasAuthority("ADMINISTRATOR")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction")
                .usernameParameter("login").passwordParameter("password").failureUrl("/login")
                .and()
                .logout().permitAll().logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }
}
