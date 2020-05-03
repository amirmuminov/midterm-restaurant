package kz.muminov.midtermrestaraunt.config;

import kz.muminov.iitu.library.config.jwt.JwtTokenAuthenticationFilter;
import kz.muminov.midtermrestaraunt.config.jwt.JwtTokenGeneratorFilter;
import kz.muminov.midtermrestaraunt.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SpringConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers("/user/**").hasAuthority("ADMINISTRATOR")
                .antMatchers("/category").hasAuthority("ADMINISTRATOR")
                .antMatchers(HttpMethod.GET, "/meal/**").permitAll()
                .antMatchers(HttpMethod.POST, "/meal").hasAuthority("ADMINISTRATOR")
                .antMatchers(HttpMethod.GET,"/order").hasAuthority("ADMINISTRATOR")
                .antMatchers( "/order", "/order/**").hasAuthority("WAITER")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoderInConfig() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoderInConfig());
    }




}
