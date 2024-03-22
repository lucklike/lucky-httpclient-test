package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Retryable;

@Retryable(retryCount = 10)
@DomainName("${API.location}")
public interface ServerBootApi {
}
