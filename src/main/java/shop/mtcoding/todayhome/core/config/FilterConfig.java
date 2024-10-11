package shop.mtcoding.todayhome.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.mtcoding.todayhome.core.filter.JwtAuthorizationFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<?> jwtAuthenticationFilter() {

        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean<>(new JwtAuthorizationFilter());
        bean.addUrlPatterns("/api.*");
        bean.setOrder(0);
        return bean;
    }
}
