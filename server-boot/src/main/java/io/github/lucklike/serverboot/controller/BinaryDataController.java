package io.github.lucklike.serverboot.controller;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.web.ContentTypeUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
public class BinaryDataController {

    @Resource(name = "savePath")
    private String savePath;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestBody byte[] fileData) throws IOException {
        // 处理二进制数据...
        // 例如，保存到文件系统或数据库等
        String mimeType = ContentTypeUtils.getMimeType(fileData);
        String fileExtension = ContentTypeUtils.getFileExtension(mimeType);
        String filePath = StringUtils.format("{}/{}.{}", savePath, NanoIdUtils.randomNanoId(5), fileExtension);
        FileCopyUtils.copy(fileData, new File(filePath));
        return filePath;
    }
}
