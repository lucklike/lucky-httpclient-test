package io.github.lucklike;

import io.github.lucklike.entity.B;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 22:41
 */
@Data
@XmlRootElement
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private List<B> b;

    public static User initIdAndAge(Integer id, Integer age) {
        return new User().setId(id).setAge(age);
    }
}
