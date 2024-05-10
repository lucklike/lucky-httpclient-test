package io.github.lucklike.api;

import com.luckyframework.httpclient.proxy.annotations.HttpRequest;
import com.luckyframework.httpclient.proxy.annotations.RespSelect;
import com.luckyframework.reflect.AnnotationUtils;
import com.luckyframework.reflect.Combination;
import io.github.lucklike.testcase.api.TranslationApi;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:34
 */
public class TranslationApiTest {

    private final TranslationApi api = Lucky.createApi(TranslationApi.class);

    @Test
    public void test() {
        System.out.println(api.trans("不要生气，保持冷静！"));
    }

    @Test
    public void test1() throws NoSuchMethodException {
        Method getName = TranslationApi.class.getDeclaredMethod("getName21");
        System.out.println(AnnotationUtils.findMergedAnnotation(getName, Combination.class));
        System.out.println(getName.getAnnotation(RespSelect.class));
        System.out.println(AnnotationUtils.findMergedAnnotation(getName, HttpRequest.class));
        System.out.println(api.getName21());
    }

}
