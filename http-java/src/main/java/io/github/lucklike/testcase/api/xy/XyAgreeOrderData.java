package io.github.lucklike.testcase.api.xy;

import lombok.Data;

/**
 * 新意协议表单数据
 *
 * @author helf
 * @date 2023年08月25日 18:02
 */
@Data
public class XyAgreeOrderData {

    /**
     * 标题
     */
    private String name;

    /**
     * 映射字段
     */
    private String code;

    /**
     * 示例
     */
    private String sample;
}
