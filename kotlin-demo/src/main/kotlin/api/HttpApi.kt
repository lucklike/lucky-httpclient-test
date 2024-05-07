package com.crh.generate.api

import com.luckyframework.httpclient.proxy.annotations.Get
import com.luckyframework.httpclient.proxy.annotations.UserInfo
import io.github.lucklike.httpclient.annotation.HttpClient

@HttpClient
interface HttpApi {

    @Get("http://www.baidu.com")
    fun baidu(@UserInfo userInfo: String) : String
}