package io.github.lucklike.serverboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class WebConfiguration {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        // 设置最大上传文件大小限制为10MB
        resolver.setMaxUploadSize(100 * 1024 * 1024);
        resolver.setMaxUploadSizePerFile(10 * 1024 * 1024);

        return resolver;
    }

}
