package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.Branch;
import com.luckyframework.httpclient.proxy.annotations.ConditionalSelection;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HttpExec;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import com.luckyframework.httpclient.proxy.annotations.StaticXmlBody;
import com.luckyframework.httpclient.proxy.annotations.UseProxy;
import io.github.lucklike.testcase.api.xy.XyAgreeData;

import java.net.Proxy;
import java.util.List;
import java.util.stream.Collectors;

//@HttpExec.okhttp3
//@BrowserFeign(userAgent = BOT)
@DomainName("http://esb17.httest.cairenhui.com:9092")
public interface _500004Api {

    //    @Timeout(connectionTimeout =  5000, readTimeout = 100, writeTimeout =100)
    @StaticXmlBody("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hts=\"http://www.htsec.com/\">\n" +
            "    <soapenv:Header/>\n" +
            "    <soapenv:Body>\n" +
            "        <hts:request>\n" +
            "            <messageRequestHead>\n" +
            "                <branchCode>004</branchCode>\n" +
            "                <consumerCode>21</consumerCode>\n" +
            "                <empCode>SYSTEM</empCode>\n" +
            "                <interfaceCode>500004</interfaceCode>\n" +
            "                <mac>A820660D0E18</mac>\n" +
            "                <reqSN></reqSN>\n" +
            "            </messageRequestHead>\n" +
            "            <messageRequestBody>\n" +
            "                <access_id>M5jYuNWof65v9TEtsckg2YtTq7zwBnfAFwIX/TkmshfBpC2pWVVRnnt7piEsIRfjSJmnSbMBJJ0xdAVdUNZ9fpAMoU7gzaA4SizTenmXC0mervtjoQWoRwM/TIVVRPXZ23HOIILtzhd9rq/T/0g7mSfALljSUjFNnRNAEU20wrA=</access_id>\n" +
            "                <app_id>JSDSCOS</app_id>\n" +
            "                <type>0</type>\n" +
            "            </messageRequestBody>\n" +
            "        </hts:request>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>")
    @Post("htesb")
    String htesb();


    @ConditionalSelection(
        branch = {
            @Branch(assertion = "#{$status$ != 200}", exception = "接口响应码异常：#{$status$}"),
            @Branch(assertion = "#{$body$.ret_code != 0}", exception = "接口响应码【#{$body$.ret_code}】，接口错误提示信息【#{$body$.ret_msg}】"),
            @Branch(assertion = "#{$body$.data_count > index}", result = "#{$this$.limit($body$.ret_data, p0)}")
        },
        defaultValue = "#{$body$.ret_data}"
    )
    @StaticJsonBody("{app_id: HTJSDWT}")
    @Post("http://xy.httest.cairenhui.com:9092/EeamsWeb/json/service/queryPTOList.do")
    List<XyAgreeData> xinyi(int limit);


    default <T> List<T> limit(List<T> list, int limit) {
        return list.stream().limit(limit).collect(Collectors.toList());
    }


    @UseProxy(type = Proxy.Type.SOCKS, ip = "203.2.114.116", port = "8112", username = "zaf55368", password = "zaf55368")
    @Get("http://www.baidu.com")
    String baidu();

}

