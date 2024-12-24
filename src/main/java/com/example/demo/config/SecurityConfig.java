package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//        .authorizeRequests(authorize -> authorize  // 这里使用的是authorizeRequests方法，而不是authorizeHttpRequests
//                .requestMatchers("/login").permitAll()   // 允许未登录用户访问登录页面
//                .anyRequest().authenticated()           // 其他请求需要认证
//            )
//            .oauth2Login(oauth2 -> oauth2
//                .loginPage("/login")                  // 自定义登录页面
//                .defaultSuccessUrl("/product")        // 登录成功后跳转页面
//            );
//        return http.build();
//    }
}

