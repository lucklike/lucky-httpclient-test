package io.github.lucklike.serverboot.controller;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import io.github.lucklike.serverboot.util.WebFileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileUploadController {

    @Resource(name = "savePath")
    private String savePath;

    @PostMapping("upload1")
    public Result<List<String>> upload(MultipartFile[] files) throws IOException {
        List<String> previewList = new ArrayList<>(files.length);
        int i = 1;
        for (MultipartFile file : files) {
            String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String fileName = StringUtils.format("{}-{}.{}", NanoIdUtils.randomNanoId(6), i++, filenameExtension);
            saveFile(file.getInputStream(), fileName);
            previewList.add(getPreviewUrl(fileName));
        }
        return Result.success(previewList);
    }

    @GetMapping("preview1/{fileName}")
    public void preview(
            HttpServletResponse response,
            @PathVariable("fileName") String fileName
    ) throws IOException {
        File file = new File(StringUtils.format("{}/{}", savePath, fileName));
        if (!file.exists()) {
            throw new RuntimeException("文件"+fileName+"不存在！");
        }
        WebFileUtils.preview(response, file);
    }

    private String getPreviewUrl(String fileName) {
        return StringUtils.format("https://localhost/file/preview/{}", fileName);
    }

    private void saveFile(InputStream in, String fileName) throws IOException {
        String filePath = StringUtils.format("{}/{}", savePath, fileName);
        WebFileUtils.copy(in, new FileOutputStream(filePath));
    }

}
