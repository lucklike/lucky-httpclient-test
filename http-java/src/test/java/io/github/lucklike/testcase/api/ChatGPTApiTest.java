package io.github.lucklike.testcase.api;

import io.github.lucklike.util.Lucky;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChatGPTApiTest {

    private final ChatGPTApi api = Lucky.createApi(ChatGPTApi.class);

    @Test
    public void send() {
        api.send("你好");
    }
}