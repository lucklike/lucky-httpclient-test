package io.github.lucklike.doccase;

import org.junit.Test;

public class _03_DomainNameApi_Test {

    private final _03_DomainNameApi api = Lucky.getApi(_03_DomainNameApi.class);

    @Test
    public void sayHelloTest() {
        System.out.println(api.sayHello("Jack"));
    }

    @Test
    public void sayHello1Test() {
        System.out.println(api.sayHello1("小黑子"));
    }
}
