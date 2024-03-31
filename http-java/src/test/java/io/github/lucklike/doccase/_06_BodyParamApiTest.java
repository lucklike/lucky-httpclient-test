package io.github.lucklike.doccase;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import io.github.lucklike.User;
import org.junit.Test;

import static io.github.lucklike.doccase._05_OtherParamApiTest.getUser;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:48
 */
public class _06_BodyParamApiTest {

    private final _06_BodyParamApi api = Lucky.getApi(_06_BodyParamApi.class);

    @Test
    public void json() {
        System.out.println(api.json(getUser("Jack")));
    }

    @Test
    public void java() {
        System.out.println(api.java(getUser("小黑子")));
    }

    @Test
    public void xml() {
        System.out.println(api.xml(getUser("Spring")));
    }


}