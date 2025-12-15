package htw.webtech.backend.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("*")
                .allowedOrigins(
                        "http://localhost:5173/",
                        "https://bibs-chat-frontend.onrender.com",
                        "https://bibs-chat-backend.onrender.com" //  Backend selbst
                )
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
