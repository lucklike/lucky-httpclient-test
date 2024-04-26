package io.github.lucklike.springboothttp.api;

import com.luckyframework.io.MultipartFile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class FileAPITest {

    @Resource
    private FileAPI fileAPI;

    @Test
    void uploadTest() {
        String[] files ={
            "https://tse2-mm.cn.bing.net/th/id/OIP-C.2zd6VjunSEhgIOVfmMFXZAHaNK?rs=1&pid=ImgDetMain",
                "file:D:/*.pdf"
        };
        System.out.println(fileAPI.upload(files));
    }

    @Test
    void uploadT2est() {
        System.out.println(fileAPI.upload2("https://tse2-mm.cn.bing.net/th/id/OIP-C.2zd6VjunSEhgIOVfmMFXZAHaNK?rs=1&pid=ImgDetMain"));
    }

    @Test
    void upload3Test() throws IOException {
        InputStream[] inArr = new InputStream[2];
        inArr[0] = fileAPI.preview("9RWx6o-2.jpg");
        inArr[1] = fileAPI.preview("Amddxk-3.jpg");
        System.out.println(fileAPI.upload3(inArr));

        for (InputStream in : inArr) {
            in.close();
        }
    }

    @Test
    void jarDownloadTest() throws IOException {
        MultipartFile mf = fileAPI.jarDownload();
//        mf.setFileName("com-back");
        mf.copyToFolder("D:/test");
    }
}
