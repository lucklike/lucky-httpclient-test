package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.IgnoreVerifySSL;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;

@SpELVar({
        "model=text-davinci-003",
        "maxTokens=50",
        "temperature=0.5"
})
@IgnoreVerifySSL
public interface ChatGPTApi {

    @StaticHeader("Authorization=Bearer #{apiKey}")
    @StaticJsonBody("{prompt: #{prompt}, max_tokens: #{maxTokens}, temperature: #{temperature}}")
    @Post("https://api.openai.com/v1/engines/#{model}/completions")
    Response send(@NotHttpParam String prompt);
}
