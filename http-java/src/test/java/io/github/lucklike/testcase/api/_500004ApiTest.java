package io.github.lucklike.testcase.api;

import com.luckyframework.spel.SpELRuntime;
import io.github.lucklike.doccase.Lucky;
import org.junit.Test;

public class _500004ApiTest {
    private final _500004Api api = Lucky.getApi(_500004Api.class);

    @Test
    public void htesb() {
        api.htesb();
    }

    @Test
    public void test() {
        SpELRuntime runtime = new SpELRuntime();

        System.out.println(runtime.getValueForType("91 + 174 + 44 + 52 + 422", int.class));
        System.out.println(runtime.getValueForType("90 + 130 + 216 + 134 + 160 + 52 + 91", int.class));
        System.out.println(runtime.getValueForType("78 + 54", int.class));
        System.out.println(runtime.getValueForType("783 + 873 + 132", int.class));
    }
}