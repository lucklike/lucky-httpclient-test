package io.github.lucklike.springboothttp.api;

import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestProxy;
import com.luckyframework.common.NanoIdUtils;
import io.github.lucklike.User;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/12 00:53
 */
@SpringBootTest
public class UserAPITest{

    @Resource
    private UserAPI userAPI;

    @Test
    public void testGet() {
        System.out.println(userAPI.get());
    }

    @Test
    public void testPut() {
        User user = userAPI.get();
        userAPI.put(user);
    }

    @Test
    public void testPutForm() {
        User user = userAPI.get();
        userAPI.putForm(user);
    }

    @Test
    public void testPutStaticForm() {
        userAPI.putStaticForm();
    }

    @Test
    public void testPost() {
        User user = userAPI.get();
        userAPI.post(user);
    }

    @Test
    public void testStaticPost() {
        userAPI.postStaticJson(NanoIdUtils.randomNanoId(16));
    }
}