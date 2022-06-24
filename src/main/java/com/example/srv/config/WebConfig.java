package com.example.srv.config;

import com.example.srv.inteceptors.BookInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author
 * @DATE 2022/6/21 -16:13
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final static String exclude[]={"/img/**"};
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

    }

    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("login.html");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BookInteceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(exclude)
        ;
    }
//  解决跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
    }
}
