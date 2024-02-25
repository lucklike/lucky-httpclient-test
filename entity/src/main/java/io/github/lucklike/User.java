package io.github.lucklike;

import lombok.Data;

/**
 * 用户实体类
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 22:41
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer age;

}
