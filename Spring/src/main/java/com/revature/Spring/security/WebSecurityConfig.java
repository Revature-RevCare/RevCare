package com.revature.Spring.security;

import com.revature.Spring.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSercurityConfig class extends the WebSecurityConfigurerAdapter class. It contains an
 * autowired UserDetailServiceImpl named userDetailsService and a private autowired AuthEntryPointJwt
 * named unauthorizedHandler. <br>
 * <b>Bean Methods</b>
 * <ul>
 *     <li>authenticationJwtTokenFilter - returns an instance of an AuthTokenFilter</li>
 *     <li>authenticationManagerBean - returns an instance of an AuthenticationManager</li>
 *     <li>passwordEncoder - returns an instance of an PasswordEncoder</li>
 * </ul>
 * <b>Override Methods</b>
 *  * <ul>
 *  *     <li>public configure - with AuthenticationManagerBuilder parameter</li>
 *  *     <li>protected configure - with HttpSecurity parameter</li>
 *  * </ul>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // secureEnabled = true,
//        jsr250Enabled = true,
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    /**
     * authenticationJwtTokenFilter bean method.
     * @return An instantiation of a Java Web Token Filter.
     */
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    /**
     * Override method configure to configure the Authentication Manager Builder.
     * @param authenticationMangerBuilder
     * @throws Exception if authentication manager builder fails to configure.
     */
    @Override
    public void configure(AuthenticationManagerBuilder authenticationMangerBuilder) throws Exception{
        authenticationMangerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    /**
     * authenticationManagerBean bean method.
     * @return An instantiation of a Authentication Manager.
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    /**
     * passwordEncoder bean method.
     * @return An instantiation of a Password Encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
