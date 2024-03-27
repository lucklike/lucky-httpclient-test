package io.github.lucklike.serverboot.doccase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP方法测试
 */
@RestController
@RequestMapping("/method/")
public class HttpMethodTestController {

    @RequestMapping("current")
    public String currentMethod(HttpServletRequest request){
        return request.getMethod();
    }
}
