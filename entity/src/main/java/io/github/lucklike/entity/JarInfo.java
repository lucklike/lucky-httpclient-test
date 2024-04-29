package io.github.lucklike.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JarInfo {

    private String groupId;
    private String artifactId;
    private String version;
}
