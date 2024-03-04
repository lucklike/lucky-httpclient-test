package io.github.lucklike.resp;

import lombok.Data;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/2 21:42
 */
@Data
public class Result<T> {

    private String code;
    private String message;
    private T data;


    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMessage("Successfully");
        result.setData(data);
        return result;
    }

    public static Result<?> error(String code, String message) {
        Result<?> result = new Result<>();
        result.setData(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
