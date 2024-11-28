package com.example.demo.config;

import java.io.IOException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> loginFilter() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        
        // 定義過濾器
        OncePerRequestFilter filter = new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                
                // 編碼
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain;charset=utf-8");

                System.out.println("攔截過濾 URL: " + request.getRequestURL());

                // 判斷是否有憑證
                HttpSession session = request.getSession();
                if (session.getAttribute("userCert") == null) {
                    response.getWriter().println("請先登入");
                    // 記住這次請求的 URL
                    session.setAttribute("redirectUrl", request.getRequestURI());
                    response.sendRedirect("/login");
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        };

        // 設置過濾器與 URL 匹配
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/user", "/users", "/product/add", "/product/self"); // 攔截這些路徑
        registrationBean.setOrder(1); // 過濾器執行順序，值越小優先級越高
        return registrationBean;
    }
}