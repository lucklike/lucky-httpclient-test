package io.github.lucklike.springboothttp.controller;

import io.github.lucklike.springboothttp.api.TranslationApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TranslationTestController {

    @Resource
    private TranslationApi api;

    @GetMapping("trans")
    public String translate(String text) {
        return api.trans(text);
    }
}
