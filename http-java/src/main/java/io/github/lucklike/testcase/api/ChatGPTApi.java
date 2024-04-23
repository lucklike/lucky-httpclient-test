package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.IgnoreVerifySSL;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import com.luckyframework.httpclient.proxy.annotations.Timeout;
import com.luckyframework.httpclient.proxy.spel.SpELVar;

@SpELVar({
        "key=#{#SM4('b2d6f4a60a29811cc19db51395160877e8809065475f5d7bb06d33f804177c8263a92db8821b8922a20518eadc389bf7deedba4ff73a91c806dc500d47d96191')}",
        "model=text-davinci-003",
        "maxTokens=50",
        "temperature=0.5"
})
@IgnoreVerifySSL
public interface ChatGPTApi {

    @Timeout(readTimeout = 60 * 60 * 1000)
    @StaticHeader("Authorization=Bearer #{key}")
    @StaticJsonBody("{prompt: #{prompt}, max_tokens: #{maxTokens}, temperature: #{temperature}}")
    @Post("https://api.openai.com/v1/engines/#{model}/completions")
    Response send(@NotHttpParam String prompt);
}
