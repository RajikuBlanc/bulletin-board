// https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#authorizeRequests()
/*
    実装方法
    https://taka31blog.com/springboot-authentication/
 */
package chalkboard.me.bulletinboard.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    // パスに対するアクセス許可の設定
    // https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // "h2-consoleから始まるパスは誰がアクセスしても良い
        /*
            .authorizeRequests() リクエストに対する許可の設定
            .antMatchers("パス").permitAll() パスに設定したものはログインの必要がない
            .anyRequest().authenticated() それ以外へのアクセスは認証（ログイン）必要
            .and() 設定を終え、次の設定の開始
            .csrf().ignoringAntMatchers("パス") パスに設定したものはcsrfの対策はしない
         */
        http.authorizeRequests()
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .antMatchers("/board").hasRole("USER")
                .and().formLogin()
                .loginPage("/user")
                .defaultSuccessUrl("/board")
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                // 同じドメインであればiframeを許可する
                .and().headers().frameOptions().sameOrigin();


    }

    // JDBC認証の構築
    // https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsManager)
                .passwordEncoder(passwordEncoder);
    }

    // 特定のリクエストを無視したい場合にしようする
    // https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
