package io.github.lucklike.springboothttp.controller;

import io.github.lucklike.resp.Result;
import io.github.lucklike.springboothttp.api.FileAPI;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fileTest")
public class FileTestController {

    @Resource
    private FileAPI api;

    @PostMapping("upload")
    public Result<List<String>> upload(@RequestBody String paths)  {
        return api.upload(paths);
    }

    @GetMapping("preview")
    public void preview(HttpServletResponse response, String fileName) throws IOException {
        FileCopyUtils.copy(api.preview(fileName), response.getOutputStream());
    }

}
