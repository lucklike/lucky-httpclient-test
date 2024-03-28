package io.github.lucklike.doccase;

import com.luckyframework.httpclient.core.RequestMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class _04_MethodApiTest {

    private final _04_MethodApi api = Lucky.getApi(_04_MethodApi.class);

    @Test
    public void test1() {
        System.out.println(api.test1());
    }

    @Test
    public void test2() {
        System.out.println(api.test2());
    }

    @Test
    public void test3() {
        System.out.println(api.test3());
    }

    @Test
    public void test4() {
        System.out.println(api.test4());
    }

    @Test
    public void test5() {
        System.out.println(api.test5());
    }

    @Test
    public void test6() {
        System.out.println(api.test6());
    }

    @Test
    public void test7() {
        System.out.println(api.test7());
    }

    @Test
    public void test8() {
        System.out.println(api.test8());
    }

    @Test
    public void test9() {
        System.out.println(api.test9());
    }

    @Test
    public void test10() {
        System.out.println(api.test10(RequestMethod.POST));
    }

    @Test
    public void test11() {
        System.out.println(api.test11("get"));
    }
}