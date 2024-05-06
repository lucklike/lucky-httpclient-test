package io.github.lucklike.springboothttp.config;

import com.luckyframework.httpclient.core.CookieStore;
import com.luckyframework.httpclient.core.JsonAutoConvert;
import com.luckyframework.httpclient.core.MemoryCookieStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/9 16:47
 */
@Configuration
public class LuckyHttpClientConfiguration {

    @Bean
    public CookieStore cookieStore() {
        return new MemoryCookieStore(10,3);
    }

    @Bean
    public JsonAutoConvert jsonAutoConvert() {
        return new JsonAutoConvert();
    }
}
