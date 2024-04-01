package io.github.lucklike.testcase.api;

import com.luckyframework.io.MultipartFile;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ScriptApiTest {

    private final ScriptApi api = Lucky.createApi(ScriptApi.class);

    @Test
    public void generate() throws IOException {
        MultipartFile mf = api.generate();
        mf.copyToFolder("D:/test");
    }
}