package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.BrowserFeign;
import com.luckyframework.httpclient.proxy.annotations.ContentCompress;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticXmlBody;
import com.luckyframework.httpclient.proxy.annotations.Timeout;

@BrowserFeign(userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36 Hutool")
@ContentCompress
@DomainName("http://esb17.httest.cairenhui.com:9092/")
public interface _500011Api {

    @StaticHeader({"Accept-Language=zh-CN,zh;q=0.8", "Accept=text/html,application/json,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"})
//    @Timeout(connectionTimeout =  60 * 1000, readTimeout = 100 * 60 * 1000, writeTimeout = 10 * 60 * 1000)
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
}

