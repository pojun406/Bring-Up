package com.bring_up.bringup.company.TestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
                .addMapping("/**")
                .allowedMethods("GET", "POST") // 원하는 HTTP 메서드로 변경
                .allowedOrigins("http://localhost:8080"); // 원하는 출처로 변경
    }

}
