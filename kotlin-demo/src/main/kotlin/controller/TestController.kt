package com.crh.generate.controller

import com.crh.generate.api.HttpApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
open class TestController {

    @Resource
    lateinit var httpApi: HttpApi;

    @GetMapping("baidu")
    open fun baidu(): String {
        return httpApi.baidu();
    }

}