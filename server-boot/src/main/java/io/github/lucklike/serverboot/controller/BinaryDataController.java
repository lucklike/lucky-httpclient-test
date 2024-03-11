package io.github.lucklike.serverboot.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class BinaryDataController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestBody byte[] fileData) throws IOException {
        // 处理二进制数据...
        // 例如，保存到文件系统或数据库等
        FileCopyUtils.copy(fileData, new File("D:/qq.png"));
        return "文件上传成功，接收到 " + fileData.length + " 字节数据";
    }
}
