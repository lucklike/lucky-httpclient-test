package io.github.lucklike.serverboot.doccase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Query参数测试类
 */

@RestController
@RequestMapping("/query/")
public class QueryParamTestController {

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return "Hello " + name;
    }


}
