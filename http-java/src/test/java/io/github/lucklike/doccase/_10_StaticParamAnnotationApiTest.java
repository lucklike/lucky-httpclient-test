package io.github.lucklike.doccase;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class _10_StaticParamAnnotationApiTest {

    private final _10_StaticParamAnnotationApi api = Lucky.getApi(_10_StaticParamAnnotationApi.class);

    @Test
    public void sayHello() {
        System.out.println(api.sayHello());
    }

    @Test
    public void path() {
        System.out.println(api.path());
    }

    @Test
    public void header() {
        System.out.println(api.header());
    }

    @Test
    public void cookie() {
        System.out.println(api.cookie());
    }

    @Test
    public void form() {
        System.out.println(api.form());
    }

    @Test
    public void form2() {
        System.out.println(api.form2());
    }

    @Test
    public void json() {
        System.out.println(api.json());
    }

    @Test
    public void xml() {
        System.out.println(api.xml());
    }

    @Test
    public void jsonSpEL() {
        System.out.println(api.jsonSpEL("爱因斯坦", "1905"));
    }
}