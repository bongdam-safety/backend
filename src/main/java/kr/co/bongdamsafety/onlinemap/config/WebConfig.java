package kr.co.bongdamsafety.onlinemap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000", "http://localhost", "http://bongdamsafe.co.kr:3000", "http://bongdamsafe.co.kr")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);

            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/upload/images/**")
                .addResourceLocations("file:C:/websites/bongdamsafe1/src/main/resources/static/upload/images/");
        registry.addResourceHandler("/static/upload/tocenter_images/**")
                .addResourceLocations("file:C:/websites/bongdamsafe1/src/main/resources/static/upload/tocenter_images/");
    }
}