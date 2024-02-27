package io.github.lucklike.api;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;

import java.util.Random;

/**
 * 动态地址
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/25 01:06
 */
@DomainName("#{$this$.getAddress()}")
public interface DynamicAddressApi {

    @Get
    String getPageContent();

    default String getAddress() {
        // 定义 3 个 IP 地址
        String[] ipArray = new String[] {
                "http://www.baidu.com",
                "https://cn.bing.com",
                "https://github.com",
        };
        // 随机选出其中一个
        return ipArray[new Random().nextInt(3)];
    }
}
