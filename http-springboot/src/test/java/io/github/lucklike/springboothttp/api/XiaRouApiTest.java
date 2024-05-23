package io.github.lucklike.springboothttp.api;

import com.luckyframework.async.EnhanceFuture;
import com.luckyframework.async.EnhanceFutureFactory;
import com.luckyframework.common.Console;
import com.luckyframework.common.StopWatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Executors;

@SpringBootTest
public class XiaRouApiTest {

    @Resource
    private XiaRouApi api;

    @Test
    void test() {
        String webUrl = "www.runoob.com";
        Set<String> webImage = api.getWebImage(webUrl);
        for (String url : webImage) {
            if (!url.contains("/")) continue;
            url = url.startsWith("..") ? url.substring(2) : url;
            url = url.startsWith("https://") ? url : webUrl + url;
            api.saveWebImage(url);
        }
    }

    @Test
    void saveBiZhiAsyncTest() {
        StopWatch sw = new StopWatch();
        sw.start("async");
        EnhanceFuture<File> futureList = new EnhanceFutureFactory().create();
        api.meiribizhi().forEach(m -> futureList.addFuture(api.saveBiZhi(m)));
        futureList.getResultMap().forEach((k, v) -> {
            Console.println("{} -> {}", k, v.getAbsolutePath());
        });
        sw.stopWatch();
        System.out.println(sw.prettyPrintMillis());
    }


    @Test
    void saveBiZhiSyncTest() {
        StopWatch sw = new StopWatch();
        sw.start("sync");
        api.meiribizhi().forEach(m -> {
            System.out.println(api.saveBiZhi2(m));
        });
        sw.stopWatch();
        System.out.println(sw.prettyPrintMillis());
    }

    @Test
    void qingTouTest() {
        StopWatch sw = new StopWatch();
        EnhanceFuture<File> futureList = new EnhanceFutureFactory(Executors.newFixedThreadPool(6)).create();
        for (int i = 0; i < 547; i++) {
            int finalI = i;
            futureList.addAsyncTask(() -> api.qingTou(finalI));
        }
        futureList.getResultMap().forEach((k, v) -> {
            Console.println("{} -> {}", k, v.getAbsolutePath());
        });
        sw.stopWatch();
        System.out.println(sw.prettyPrintMillis());
    }

    @Test
    void testt() {
        api.qingTou(3);
        api.qingTou(4);
    }
}
