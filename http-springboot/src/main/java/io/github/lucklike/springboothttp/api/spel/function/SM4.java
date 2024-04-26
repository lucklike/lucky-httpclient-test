package io.github.lucklike.springboothttp.api.spel.function;

import com.luckyframework.httpclient.proxy.annotations.ArgHandle;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@NotHttpParam
@ArgHandle("#{#SM4(_value_)}")
public @interface SM4 {
}
