package io.github.lucklike.serverboot.doccase;

import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 19:16
 */
@RestController
@RequestMapping("file")
public class FileParamTestController implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Value("${server.port}")
    private String port;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("preview/{fileName}")
    public void preview(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
        Resource resource = resourceLoader.getResource(StringUtils.format("classpath:upload/{}", fileName));
        InputStream in = resource.getInputStream();
        ServletOutputStream out = response.getOutputStream();
        FileCopyUtils.copy(in, out);
    }

    @PostMapping("upload")
    public Result<Map<String, Object>> upload(String desc, MultipartFile[] files) throws IOException {
        Map<String, Object> map = new HashMap<>();
        List<String> filePaths = new ArrayList<>();
        map.put("urls", filePaths);
        map.put("desc", desc);

        for (MultipartFile file : files) {
            File localFile = getLocalFile(file.getOriginalFilename());
            FileCopyUtils.copy(file.getInputStream(), Files.newOutputStream(localFile.toPath()));
            filePaths.add(StringUtils.format("http://localhost:{}/file/preview/{}", port, file.getOriginalFilename()));
        }
        return Result.success(map);
    }

    @PostMapping("binaryUpload")
    public Result<String> binaryUpload(@RequestBody byte[] bytes, @RequestHeader("fileName") String fileName) throws IOException {
        File localFile = getLocalFile(fileName);
        FileCopyUtils.copy(bytes, Files.newOutputStream(localFile.toPath()));
        return Result.success(StringUtils.format("http://localhost:{}/file/preview/{}", port, fileName));
    }


    private File getLocalFile(String fileName) {
       return new File("/Users/fukang/Lucky/lucky-httpclient-test/server-boot/src/main/resources/upload/" + fileName);
    }
}
