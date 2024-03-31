package io.github.lucklike.doccase;

import com.luckyframework.io.MultipartFile;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 19:57
 */
public class _07_FileParamApiTest {

    private final _07_FileParamApi api = Lucky.getApi(_07_FileParamApi.class);

    @Test
    public void upload() {
        File[] files = new File[] {
                new File("/Users/fukang/Pictures/OIP-C.jpeg"),
                new File("/Users/fukang/Pictures/R-C.jpeg")
        };
        api.upload("本地文件", files);

    }

    @Test
    public void upload2() {
        String[] files = {
                "https://ts1.cn.mm.bing.net/th/id/R-C.b56aa4bb51cabc689de0e62b44e9ded1?rik=68%2bi6nBs8vAjaA&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50062%2f5802.jpg_wh1200.jpg&ehk=fapBxRe0u39jJ8t3P3G2Qobt2aqqpWZaTACd54Ycyzc%3d&risl=&pid=ImgRaw&r=0",
                "file:/Users/fukang/Desktop/\uD83E\uDD55/405731702729632_.pic_hd.jpg"
        };
        api.upload2("HTTP文件", files);
    }

    @Test
    public void binaryUpload() {
        File file = new File("/Users/fukang/Pictures/avatar.jpg");
        api.binaryUpload(file);
    }

    @Test
    public void preview() throws IOException {
        byte[] bytes = api.preview("7ef9c4ef902854a89af881815f5339bc.jpg");
        FileCopyUtils.copy(bytes, new File("/Users/fukang/Pictures/1234.jpg"));
    }

    @Test
    public void preview2() throws IOException {
        MultipartFile mf = api.preview2("7ef9c4ef902854a89af881815f5339bc.jpg");
        mf.copyToFolder("/Users/fukang/Pictures/");
    }
}