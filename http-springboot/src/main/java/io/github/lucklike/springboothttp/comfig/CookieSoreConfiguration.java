package io.github.lucklike.springboothttp.comfig;

import com.luckyframework.httpclient.core.CookieStore;
import com.luckyframework.httpclient.core.MemoryCookieStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/9 16:47
 */
@Configuration
public class CookieSoreConfiguration {

    @Bean
    public CookieStore cookieStore() {
        return new MemoryCookieStore(10,3);
    }
}
