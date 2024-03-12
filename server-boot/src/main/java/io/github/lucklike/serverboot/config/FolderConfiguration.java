package io.github.lucklike.serverboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FolderConfiguration {


    @Bean("savePath")
    @ConditionalOnOs("windows")
    public String saveFilePathWindows() {
        return "D:/test";
    }

    @Bean("savePath")
    @ConditionalOnOs("mac")
    public String saveFilePathMac() {
        return "/Users/fukang/Desktop/test";
    }
}



