package kr.co.bongdamsafety.onlinemap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 생성자: WebConfig의 기본 생성자
    public WebConfig() {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/upload/images/**")
                .addResourceLocations("file:C:/websites/bongdamsafe1/src/main/resources/static/upload/images/");
        registry.addResourceHandler("/static/upload/tocenter_images/**")
                .addResourceLocations("file:C:/websites/bongdamsafe1/src/main/resources/static/upload/tocenter_images/");
    }

    // CORS(Cross-Origin Resource Sharing) 설정을 추가하는 메소드
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 경로에 대해 CORS를 설정합니다.
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정
                .allowedOrigins(new String[]{"http://localhost:3000"}) // 허용할 출처: localhost:8080 이건 나중에 변경
                //.allowedOrigins("http://localhost:3000") // 전체 출처 허용
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"}) // 허용할 HTTP 메소드
                .allowCredentials(true); // 자격 증명(쿠키 등)을 포함한 요청 허용
    }
}