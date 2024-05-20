package io.github.lucklike.springboothttp.api;

import com.luckyframework.io.MultipartFile;
import io.github.lucklike.entity.JarInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class FileAPITest {

    @Resource
    private FileAPI fileAPI;

    @Test
    void uploadTest() {
        String[] files = {
                "https://tse2-mm.cn.bing.net/th/id/OIP-C.2zd6VjunSEhgIOVfmMFXZAHaNK?rs=1&pid=ImgDetMain",
                "file:D:/*.pdf"
        };
        System.out.println(fileAPI.upload(files, "来自网络和本地的文件"));
    }

    @Test
    void uploadT2est() {
        System.out.println(fileAPI.upload2("https://tse2-mm.cn.bing.net/th/id/OIP-C.2zd6VjunSEhgIOVfmMFXZAHaNK?rs=1&pid=ImgDetMain"));
    }

    @Test
    void upload3Test() throws IOException {
        InputStream[] inArr = new InputStream[2];
        inArr[0] = fileAPI.preview("f-yfB.pdf");
        inArr[1] = fileAPI.preview("123.pdf");
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

    @Test
    void jarDownload2Test() throws IOException {
        fileAPI.jarDownload(new JarInfo().setGroupId("com.cairh1").setArtifactId("cpe-common-backend").setVersion("0.1.20"))
                .copyToFolder("D:/test");
    }

    @Test
    void jarToLocalTest() throws IOException {
        System.out.println(fileAPI.jarToLocal(
                new JarInfo()
                        .setGroupId("com.cairh")
                        .setArtifactId("cpe-common-backend")
                        .setVersion("0.1.20")));
    }

    @Test
    void jarToLocal2Test() throws IOException {
        File file = fileAPI.jarToLocal(
                new JarInfo()
                        .setGroupId("com.cairh")
                        .setArtifactId("cpe-common-backend")
                        .setVersion("0.1.20")
                , "D:/crh/jar");
        System.out.println(file);
    }
}
