package security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    UserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        // creo un authentication provider basato su database Data Access Object
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // associo il mio DatabaseUserDetailsService
        provider.setUserDetailsService(userDetailsService());
        // associo il mio PasswordEncoder
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                /*.antMatchers("/categories", "/categories/**").hasAuthority("ADMIN")
                .antMatchers("/photos/create", "/photos/edit/**", "/photos/delete/**").hasAuthority("ADMIN")*/
                .antMatchers("/home").hasAnyAuthority("User", "Admin")
                /*.antMatchers(HttpMethod.POST, "/photos/**").hasAuthority("ADMIN")*/
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .and().logout()
                .and().exceptionHandling();

        http.csrf().disable(); //USE ONLY IN DEVELOPMENT
        return http.build();
    }

}

