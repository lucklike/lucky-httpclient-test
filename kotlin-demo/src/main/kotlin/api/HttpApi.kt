package com.crh.generate.api

import com.luckyframework.httpclient.proxy.annotations.Get
import io.github.lucklike.httpclient.annotation.HttpClient

@HttpClient
interface HttpApi {

    @Get("http://www.baidu.com")
    fun baidu() : String
}