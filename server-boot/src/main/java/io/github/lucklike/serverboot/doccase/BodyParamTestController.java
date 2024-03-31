package io.github.lucklike.serverboot.doccase;

import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.serializable.JDKSerializationScheme;
import com.luckyframework.serializable.SerializationScheme;
import com.luckyframework.serializable.SerializationSchemeFactory;
import com.luckyframework.serializable.XmlSerializationScheme;
import io.github.lucklike.User;
import io.github.lucklike.resp.Result;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:35
 */
@RestController
@RequestMapping("body")
public class BodyParamTestController {

    private final JDKSerializationScheme jdkScheme = SerializationSchemeFactory.getJdkScheme();
    private final XmlSerializationScheme xmlScheme = SerializationSchemeFactory.getXmlScheme();

    @PostMapping("json")
    public Result<User> json(@RequestBody User user){
        return Result.success(user);
    }

    @PostMapping("java")
    public void java(HttpServletResponse response, @RequestBody byte[] userByte) throws Exception {
        User user = ConversionUtils.conversion(jdkScheme.fromByte(userByte), User.class) ;
        response.setContentType("application/x-java-serialized-object");
        ServletOutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(jdkScheme.toByte(Result.success(user)), outputStream);
    }

    @PostMapping(value = "xml", produces = "application/xml")
    public User java(@RequestBody String userXml) throws Exception {
        User user = (User) xmlScheme.deserialization(userXml, User.class);
        return user;
    }
}
