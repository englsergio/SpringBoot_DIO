package dio.dio.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityDatabaseService securityDatabaseService;
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDatabaseService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/list-users").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/managers").hasAnyRole("MANAGERS")
                .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
//                .anyRequest().authenticated().and().formLogin(); //agora não usaremos a tela de login p/ auth.
                .anyRequest().authenticated().and().httpBasic(); //Tipo de auth httpBasic
    }
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")// {noop} é a alternativa de criptografia / outros tipos abaixo
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}password")
                .roles("MANAGERS");
    }
    */
}
//{bcrypt} for BCryptPasswordEncoder (mais comum)
//{noop} for NoOpPasswordEncoder
//{pbkdf2} for Pbkdf2PasswordEncoder
//{scrypt} for SCryptPasswordEncoder
//{sha256} for StandartPasswordEncoder

