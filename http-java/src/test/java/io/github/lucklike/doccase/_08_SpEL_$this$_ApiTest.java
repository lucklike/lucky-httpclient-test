package io.github.lucklike.doccase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/31 00:54
 */
public class _08_SpEL_$this$_ApiTest {

    private final _08_SpEL_$this$_Api api = Lucky.getApi(_08_SpEL_$this$_Api.class);

    @Test
    public void index() {
        System.out.println(api.index());
        System.out.println(api.index());
        System.out.println(api.index());
    }
}