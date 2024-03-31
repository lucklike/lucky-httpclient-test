package io.github.lucklike.doccase;


import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import io.github.lucklike.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:22
 */
public class _05_OtherParamApiTest {

    private final _05_OtherParamApi api = Lucky.getApi(_05_OtherParamApi.class);

    @Test
    public void path() {
        System.out.println(api.path("Jack"));
    }

    @Test
    public void header() {
        System.out.println(api.header(NanoIdUtils.randomNanoId(15)));
    }

    @Test
    public void cookie() {
        System.out.println(api.cookie("妞妞"));
    }

    @Test
    public void form1() {
        System.out.println(api.form1("lucky", "PA$$W0RD"));
    }

    @Test
    public void form2() {
        System.out.println(api.form2("tom", "__tom_mot__"));
    }

    @Test
    public void form3() {
        Map<String, Object> formMap = new HashMap<>();
        formMap.put("name", "小黄鸭");
        formMap.put("age", 3);
        formMap.put("sex", "男");
        System.out.println(api.form3(formMap));
    }

    @Test
    public void form4() {
        System.out.println(api.form4(getUser("雪王八")));
    }

    public static User getUser(String username) {
        User user = new User();
        user.setId((int)(Math.random() * 1000));
        user.setUsername(username);
        user.setPassword(NanoIdUtils.randomNanoId());
        user.setAge(12);
        user.setEmail(StringUtils.format("{}@qq.com", NanoIdUtils.randomNanoId(8)));
        return user;
    }
}