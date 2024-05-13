package io.github.lucklike.convert;

import com.luckyframework.conversion.ConversionMethod;
import com.luckyframework.conversion.Mapping;
import io.github.lucklike.User;
import io.github.lucklike.entity.JarInfo;

public interface UserJarInfoConvert2 {

    @Mapping(target = "username", source = "groupId")
    @Mapping(target = "password", source = "artifactId")
    @Mapping(target = "email", source = "version")
    @ConversionMethod
    User toUser(JarInfo source);


    @Mapping(source = "username", target = "groupId")
    @Mapping(source = "password", target = "artifactId")
    @Mapping(source = "email", target = "version")
    @ConversionMethod
    JarInfo toJarInfo(User target);
}
