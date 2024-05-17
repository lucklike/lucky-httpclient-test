package io.github.lucklike.convert;

import com.luckyframework.conversion.FieldSuppler;
import com.luckyframework.conversion.Interconversion;
import com.luckyframework.conversion.Mapping;
import com.luckyframework.conversion.TargetField;
import com.luckyframework.conversion.TargetInitialSuppler;
import com.luckyframework.conversion.UseConversion;
import io.github.lucklike.User;
import io.github.lucklike.entity.JarInfo;

@UseConversion(classes = {ABConvert.class})
public interface UserJarInfoConvert extends Interconversion<User, JarInfo> {

    @Mapping(target = "username", source = "groupId")
    @Mapping(target = "password", source = "artifactId")
    @Mapping(target = "email", source = "version")
    @Mapping(target = "b", source = "a")
    @FieldSuppler(name = "b", suppler = "new java.util.LinkedList()")
    User toTarget(JarInfo source);


    @Mapping(source = "username", target = "groupId")
    @Mapping(source = "password", target = "artifactId")
    @Mapping(source = "email", target = "version")
    @Mapping(source = "b", target = "a")
    JarInfo toSource(User target);
}
