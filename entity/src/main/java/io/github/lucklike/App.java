package io.github.lucklike;

import com.luckyframework.conversion.ConversionUtils;
import io.github.lucklike.convert.UserJarInfoConvert;
import io.github.lucklike.convert.UserJarInfoConvert2;
import io.github.lucklike.entity.JarInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        convertArrayTest();
    }

    private static void convertTest() {
        UserJarInfoConvert convert = ConversionUtils.getConversionServiceProxy(UserJarInfoConvert.class);

        JarInfo jarInfo = convert.toSource(new User().setUsername("jack").setPassword("PA$$W0RD").setEmail("jack@lucklike.io"));
        System.out.println(jarInfo);

        User user = convert.toTarget(jarInfo);
        System.out.println(user);

    }

    private static void convert2Test() {
        UserJarInfoConvert2 convert = ConversionUtils.getConversionServiceProxy(UserJarInfoConvert2.class);

        JarInfo jarInfo = convert.toJarInfo(new User().setUsername("jack").setPassword("PA$$W0RD").setEmail("jack@lucklike.io"));
        System.out.println(jarInfo);

        User user = convert.toUser(jarInfo);
        System.out.println(user);

    }

    private static void convertArrayTest() {
        UserJarInfoConvert convert = ConversionUtils.getConversionServiceProxy(UserJarInfoConvert.class);

        List<User> list = Collections.singletonList(new User().setUsername("jack").setPassword("PA$$W0RD").setEmail("jack@lucklike.io"));
        JarInfo[] userInfoArray = convert.toSourceArray(list);
        System.out.println(Arrays.toString(userInfoArray));
    }
}
