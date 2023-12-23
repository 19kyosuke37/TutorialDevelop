package com.techacademy;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // コンフィグレーションクラス（設定クラス）であることの明示
public class SecurityConfig {

    @Bean // DIコンテナの登録対象にする
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login.loginProcessingUrl("/login").loginPage("/login").defaultSuccessUrl("/user/list")
                .failureUrl("/login?error").permitAll()).logout(logout -> logout.logoutSuccessUrl("/login"))
                .authorizeHttpRequests(auth -> auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                        .permitAll().anyRequest().authenticated());

        return http.build();

    }

    @Bean // DIコンテナの登録対象にする
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
