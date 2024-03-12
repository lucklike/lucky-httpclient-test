package io.github.lucklike.serverboot.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty("os.name");
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnOs.class.getName());
        String configValue = (String) annotationAttributes.get("value");
        return osName.toLowerCase().contains(configValue.toLowerCase());
    }
}
