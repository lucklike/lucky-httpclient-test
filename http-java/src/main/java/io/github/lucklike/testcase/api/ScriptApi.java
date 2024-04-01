package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import com.luckyframework.io.MultipartFile;

@DomainName("http://localhost:8864/script/")
public interface ScriptApi {

    @StaticJsonBody("{\n" +
            "  \"name\": \"系统参数配置\",\n" +
            "  \"version\": \"sysparamconfig_insert\",\n" +
            "  \"fileName\": \"BASEDATA-772_user_Basedata_syspropertyconfig\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"schema\": \"crh_user\",\n" +
            "      \"exegesis\": \"BASEDATA-772 IP黑名单配置\",\n" +
            "\n" +
            "      \"config_id\": \"basedata_business\",\n" +
            "      \"label_sys\": \"IP黑名单配置\",\n" +
            "      \"description\": \"在此IP段内的用户需要检查【见证人vpn登录权限】有才放行，多个IP段直接使用`,`隔开,支持以下三种配置：1. X.X.X.X-X.X.X.X (-指定范围)；2. X.X.X.X/X (CIDR指定范围)；3. X.X.X.X 单独的IP配置\",\n" +
            "      \"order_no\": \"1\",\n" +
            "      \"show_flag\": \"1\",\n" +
            "      \"property_key\": \"base.validate.blackList.intranetIpSections\",\n" +
            "      \"property_value\": \" \",\n" +
            "      \"validator_type\": \" \",\n" +
            "      \"validator_content\": \" \"\n" +
            "    }\n" +
            "  ]\n" +
            "}")
    @Post("generate")
    MultipartFile generate();
}
