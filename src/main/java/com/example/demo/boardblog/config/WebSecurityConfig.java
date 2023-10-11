// package com.example.demo.boardblog.config;

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Configurable;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.demo.boardblog.filter.JwtAuthenticationFilter;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;

// @Configurable
// @EnableWebSecurity
// @RequiredArgsConstructor
// public class WebSecurityConfig {
    
//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     @Bean
//     protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
//         httpSecurity
//             .cors().and()
//             .csrf().disable() // 사용자가 로그인한 상태에서 어떤행동을 하게 하는 것
//             .httpBasic().disable()
//             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//             .authorizeRequests()
//             .antMatchers("/","/api/v1/auth/**","/api/v1/search/**","/file/**").permitAll()
//             .antMatchers(HttpMethod.GET,"/api/v1/board/**","/api/v1/user/*").permitAll()
//             .anyRequest().authenticated().and()
//             .exceptionHandling().AuthenticationEntryPoint(new FailedAuthenticationEntryPoint());

//         httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//         return httpSecurity.build();

//     }
// }

// class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint {

//     @Override
//     public void commence(HttpServletRequest request, HttpServletResponse response,
//             AuthenticationException authException) throws IOException, ServletException {
                
//         response.setContentType("application/join");
//         response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//         response.getWriter().write("{\"code\":\"NP\",\"message\":\"Do not have premission.\"}");
//     }

// }
