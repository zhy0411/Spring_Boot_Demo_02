package SpringBoot_Demo_02.config;

import SpringBoot_Demo_02.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现WebMvcConfigurer不会导致静态资源被拦截
        registry.addInterceptor(new MyInterceptor())
                // 拦截所有url
                .addPathPatterns("/**")
                // 放行swagger
                .excludePathPatterns("/swagger-resources/**");
    }
}
