package io.github.lucklike.testcase.api.xy;

import lombok.Data;

import java.util.List;

/**
 * 新意协议数据
 *
 * @author helf
 * @date 2023年08月25日 18:01
 */
@Data
public class XyAgreeData {

    /**
     * 协议文件
     */
    private List<XyAgreeFileData> files;

    /**
     * 是否有签字域
     */
    private String has_sign_area;

    /**
     * 是否必读
     */
    private String is_need_read;

    /**
     * 协议ID
     */
    private String pv_id;

    /**
     * 协议编号
     */
    private String protocol_code;

    /**
     * 存管银行编号
     */
    private String bank_code;

    /**
     * 协议内容
     */
    private String protocol_values;

    /**
     * 是否需要签字
     */
    private String isneed_sign;

    /**
     * 阅读时长
     */
    private String read_time;

    /**
     * 协议domain
     */
    private String file_domain;

    /**
     * 协议版本
     */
    private String version_no;

    /**
     * 协议表单数据
     */
    private List<XyAgreeOrderData> order_data;

    /**
     * 生效时间
     */
    private String effective_date;

    /**
     * 是否分享
     */
    private String is_share;

    /**
     * 协议名称
     */
    private String protocol_name;

    /**
     * 手写数据
     */
    private List<String> handWriteArr;

    /**
     * 失效时间
     */
    private String invalid_date;

    /**
     * 业务类型
     */
    private String order_type;
}
