package kr.co.bongdamsafety.onlinemap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    public SecurityConfig() {
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                // 정보조회 및 요청 관련 기능
                                "/",
                                "/api/facility",
                                "/api/facility/{id}",
                                "/api/facility/category/{id}",
                                "/api/facilityCategory",
                                "/api/facilityCategory/{id}",
                                "/api/request_Edit",
                                "/api/request_ToCenter",
                                // 계정 관련 기능
                                "/api/users/register",
                                "/api/users/login",
                                // 이미지인식 및 문자전송 관련 기능
                                "/api/upload",
                                "/api/send-sms",

                                // 임시로, 로그인 없이도 모든 api에 접근 가능하도록 설정
                                "/api/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
