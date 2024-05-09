package io.github.lucklike.testcase.api.xy;

import lombok.Data;

/**
 * 新意协议文件数据
 *
 * @author helf
 * @date 2023年08月25日 18:02
 */
@Data
public class XyAgreeFileData {

    /**
     * 文件id
     */
    private String file_id;

    /**
     * 文件md5
     */
    private String md5;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件sha1
     */
    private String sha1;

    /**
     * 文件类型
     */
    private String type;
}
