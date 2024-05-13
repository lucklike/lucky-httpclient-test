package io.github.lucklike.convert;

import com.luckyframework.conversion.Interconversion;
import com.luckyframework.conversion.Mapping;
import io.github.lucklike.User;
import io.github.lucklike.entity.JarInfo;

public interface UserJarInfoConvert extends Interconversion<User, JarInfo> {

    @Mapping(target = "username", source = "groupId")
    @Mapping(target = "password", source = "artifactId")
    @Mapping(target = "email", source = "version")
    User toTarget(JarInfo source);


    @Mapping(source = "username", target = "groupId")
    @Mapping(source = "password", target = "artifactId")
    @Mapping(source = "email", target = "version")
    JarInfo toSource(User target);
}
