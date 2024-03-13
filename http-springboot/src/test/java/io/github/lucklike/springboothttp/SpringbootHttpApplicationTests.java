package io.github.lucklike.springboothttp;

import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.httpclient.core.BodyObject;
import io.github.lucklike.springboothttp.api.BinaryDataAPI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class SpringbootHttpApplicationTests {

    @Resource
    private BinaryDataAPI binaryDataAPI;

    @Test
    void uploadTest() throws IOException {
        System.out.println(binaryDataAPI.upload(BodyObject.byteBody("https://file.moyublog.com/d/file/2021-02-21/751d49d91fe63a565dff18b3b97ca7c8.jpg")));
    }

    @Test
    void upload2Test() {
        System.out.println(binaryDataAPI.upload2("https://file.moyublog.com/d/file/2021-02-21/751d49d91fe63a565dff18b3b97ca7c8.jpg"));
    }

    @Test
    void upload3Test() throws IOException {
        org.springframework.core.io.Resource resource = ConversionUtils.conversion("https://ts1.cn.mm.bing.net/th/id/R-C.5d0c289d1219b6663b9432bcb3fd96d4?rik=mVNpEwZk0wHdEQ&riu=http%3a%2f%2fimg.zcool.cn%2fcommunity%2f017b1b57f455c7a84a0e282bee54c3.jpg%403000w_1l_2o_100sh.jpg&ehk=8rEwMuLV1vuG7ibHvrC0ygdapp6NPMSc1Fu5irZqD40%3d&risl=&pid=ImgRaw&r=0", org.springframework.core.io.Resource.class);
        System.out.println(binaryDataAPI.upload3(FileCopyUtils.copyToByteArray(resource.getInputStream()), "cvwevebebwve"));
    }

    @Test
    void upload4Test() {
        System.out.println(binaryDataAPI.upload4("https://tse2-mm.cn.bing.net/th/id/OIP-C.6AX-5XycsrExkSFt0Vc51wHaLH?w=1360&h=2040&rs=1&pid=ImgDetMain"));
    }

    @Test
    void upload5Test() throws IOException {
        InputStream in = Files.newInputStream(Paths.get("D:\\data\\htdev\\arch\\archivefiles\\20240306\\10009KS_0132_1765183737473474560.pdf"));
        System.out.println(binaryDataAPI.upload5(in));
    }

    @Test
    void upload6Test() {
        File file = new File("D:\\data\\htdev\\arch\\archivefiles\\20240306\\10009KS_0132_1765183737473474560.pdf");
        System.out.println(binaryDataAPI.upload6(file));
    }

}
