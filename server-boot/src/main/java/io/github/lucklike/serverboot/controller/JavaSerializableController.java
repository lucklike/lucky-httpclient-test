package io.github.lucklike.serverboot.controller;

import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.serializable.JDKSerializationScheme;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.User;
import io.github.lucklike.resp.Result;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("java")
public class JavaSerializableController {

    private final JDKSerializationScheme jdkScheme = SerializationSchemeFactory.getJdkScheme();

    @GetMapping("getObject")
    public void getObject(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("J___ack付款————-");
        user.setPassword("PA$$W0RD");
        user.setAge(27);
        user.setEmail("1814378890@qq.com");

        response.setContentType("application/x-java-serialized-object");
        ServletOutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(jdkScheme.toByte(user), outputStream);
    }

    @PutMapping("putObject")
    public Result<User> putObject(@RequestBody byte[] objectBytes) throws Exception {
        User user = ConversionUtils.conversion(jdkScheme.fromByte(objectBytes), User.class) ;
        return Result.success(user);
    }
}
