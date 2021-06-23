package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ComponentScan
@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	
	@Autowired AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	log.info("설정파일 통과");
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/v2/cars/**")
                .addPathPatterns("/cars/list")
                .excludePathPatterns("/api/v1/login/**");
    }

}