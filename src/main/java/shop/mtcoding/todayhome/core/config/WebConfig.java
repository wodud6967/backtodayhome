package shop.mtcoding.todayhome.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration // IoC 에 저장됨
public class WebConfig implements WebMvcConfigurer {

    // 웹서버 폴더 추가
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // 1. 절대경로 file:///c:/upload/
        // 2. 상대경로 file:./upload/
        registry
                .addResourceHandler("/images/**") // 매핑 경로
                .addResourceLocations("file:" + "./images/") // 실제 파일이 저장된 서버의 경로
                .setCachePeriod(60 * 60) // 초 단위 => 한시간, 리소스를 캐시할 시간
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
