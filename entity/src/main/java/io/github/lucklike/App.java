package io.github.lucklike;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.conversion.ConversionUtils;
import io.github.lucklike.convert.UserJarInfoConvert;
import io.github.lucklike.convert.UserJarInfoConvert2;
import io.github.lucklike.entity.B;
import io.github.lucklike.entity.JarInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        convertTest();
    }

    private static void convertTest() {
        UserJarInfoConvert convert = ConversionUtils.getConversionServiceProxy(UserJarInfoConvert.class);

        JarInfo jarInfo = convert.toSource(new User()
                .setUsername("jack")
                .setPassword("PA$$W0RD")
                .setEmail("jack@lucklike.io")
                .setB(Arrays.asList(getB("NAME", 14.5), getB("名称", 3364d), getB("长长久久", 99.99d))));
        System.out.println(jarInfo);

        User user = convert.toTarget(jarInfo);
        System.out.println(user);

    }

    private static void convert2Test() {
        UserJarInfoConvert2 convert = ConversionUtils.getConversionServiceProxy(UserJarInfoConvert2.class);

        JarInfo jarInfo = convert.toJarInfo(
                new User()
                        .setUsername("jack")
                        .setPassword("PA$$W0RD")
                        .setEmail("jack@lucklike.io"));
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

    private static B getB(String name, Double price) {
        B b = new B();
        b.setName(name);
        b.setB_decs(NanoIdUtils.randomNanoId());
        b.setB_price(String.valueOf(price));
        return b;
    }
}
