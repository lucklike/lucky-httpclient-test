package io.github.lucklike.api.https;

import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.executor.HttpExecutor;
import com.luckyframework.httpclient.core.executor.JdkHttpExecutor;
import com.luckyframework.httpclient.core.ssl.SSLUtils;
import com.luckyframework.httpclient.core.ssl.TrustAllHostnameVerifier;
import org.junit.Test;

public class HttpsTest {

    /**
     * 跳过证书认证测试
     */
    @Test
    public void test1() throws Exception {
        HttpExecutor httpExecutor = new JdkHttpExecutor();
        Request request = Request.get("https://localhost/simple/hi/练习时长两年半的【蔡徐坤】")
                .setHostnameVerifier(TrustAllHostnameVerifier.DEFAULT_INSTANCE)
                .setSSLSocketFactory(SSLUtils.createIgnoreVerifySSL(null).getSocketFactory());
        System.out.println(httpExecutor.execute(request).getStringResult());
    }

}
