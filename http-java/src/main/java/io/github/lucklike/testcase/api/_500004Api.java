package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.BrowserFeign;
import com.luckyframework.httpclient.proxy.annotations.ContentCompress;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.HttpExec;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticXmlBody;
import com.luckyframework.httpclient.proxy.annotations.Timeout;

import static com.luckyframework.httpclient.proxy.annotations.BrowserFeign.BOT;

@HttpExec.okhttp3
@BrowserFeign(userAgent = BOT)
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

}

