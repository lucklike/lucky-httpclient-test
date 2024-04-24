package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.ProtobufBody;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.ResponseSelect;
import io.github.lucklike.httpclient.annotation.HttpClientComponent;
import io.github.lucklike.proto.DemoProto;

@HttpClientComponent
public interface ProtobufApi extends ServerBootApi {

    @Put("/protobuf/put1")
    void put(@ProtobufBody DemoProto.Demo demo);

    @ResponseSelect(expression = "#{$body$.id + '-' + $body$.code + '-' + $body$.name}", metaType = DemoProto.Demo.class)
    @Get("/protobuf/get2")
    String get(String name);
}
