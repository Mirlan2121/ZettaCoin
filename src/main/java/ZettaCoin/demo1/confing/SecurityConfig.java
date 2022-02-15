package ZettaCoin.demo1.confing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/Dev/**").permitAll()
                .antMatchers(HttpMethod.GET,"/Dev/get-current/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/Dev/deleteDev/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET, "/Dev/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/Dev/getAll/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET, "/Dev/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/Dev/get-current/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login, password, active from developers d  where login=?")
                .authoritiesByUsernameQuery
                        ("select d.login, dr.role_name  as role from developer_role dr inner join developers d on dr.developer_id = d.id = " +
                                "where d.login=? and d.active=1");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
