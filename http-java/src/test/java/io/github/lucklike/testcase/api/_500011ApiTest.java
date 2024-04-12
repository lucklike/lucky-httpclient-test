package io.github.lucklike.testcase.api;

import io.github.lucklike.doccase.Lucky;
import org.junit.Test;

import static org.junit.Assert.*;

public class _500011ApiTest {
    private final _500011Api api = Lucky.getApi(_500011Api.class);

    @Test
    public void htesb() {
        api.htesb();
    }
}