package io.github.lucklike.api;

import io.github.lucklike.testcase.api.TestAPI;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class TestAPITest {

    private TestAPI api = Lucky.createApi(TestAPI.class);

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        System.out.println(api.test().get());
    }

    @Test
    public void test2() {
       api.test1("Jack", 123);
    }

    @Test
    public void test3() {
        api.test2(new String[]{"Jack", "Tom", "Karl"});
        api.test1("Jack", 123);
        api.test1("Jack", 123);
    }

    @Test
    public void test4() {
        api.test3( "user=123", "pwd=334564积极");
    }

    @Test
    public void test5() {
        System.out.println(api.test4("/operator-manage/list"));
    }
}
