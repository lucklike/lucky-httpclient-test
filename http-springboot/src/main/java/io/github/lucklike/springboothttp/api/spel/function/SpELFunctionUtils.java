package io.github.lucklike.springboothttp.api.spel.function;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.spel.FunctionAlias;
import com.luckyframework.httpclient.proxy.spel.FunctionFilter;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.entity.JarInfo;
import io.github.lucklike.httpclient.annotation.SpELFunction;
import io.github.lucklike.util.SM4Util;

@SpELFunction
public class SpELFunctionUtils {

    /**
     * 字符串格式化输出
     * @param temp 字符串模版
     * @param args 模版参数
     * @return 完整字符串
     */
    @FunctionAlias("FORMAT")
    public static String format(String temp, Object... args) {
        return StringUtils.format(temp, args);
    }

    /**
     * 拼接URL
     * @param pathPrefix 路径前缀
     * @param pathSuffix 路径后置
     * @return 完整URL
     */
    @FunctionAlias("URL")
    public static String urlJoin(String pathPrefix, String pathSuffix) {
        return StringUtils.joinUrlPath(pathPrefix, pathSuffix);
    }

    /**
     * 生成NanoId随机字符串
     * @return NanoId随机字符串
     */
    @FunctionFilter
    public static String nanoId(){
        return NanoIdUtils.randomNanoId();
    }

    /**
     * SM4解密算法
     * @param s SM4加密后的字符串
     * @return 加密前的明文
     */
    @FunctionAlias("SM4")
    public static String SM4(String s) throws Exception {
        return SM4Util.decryptEcb(s);
    }

    /**
     * 用于将Json字符串转为Java对象
     * @param jsonStr json字符串
     * @return 转化后的Java对象
     */
    @FunctionAlias("JSON")
    public static Object fromJson(String jsonStr) throws Exception {
        return SerializationSchemeFactory.getJsonScheme().deserialization(jsonStr, Object.class);
    }

    // com/cairh/cpe-common-backend/0.1.17/cpe-common-backend-0.1.17-sources.jar
    @FunctionAlias("TO_PATH")
    public static String toPath(JarInfo jarInfo){
        String pathTemp = "{}/{}/{}/{}-{}-sources.jar";
        String groupIdPath = jarInfo.getGroupId().replace(".", "/");
        return StringUtils.format(pathTemp, groupIdPath, jarInfo.getArtifactId(), jarInfo.getVersion(), jarInfo.getArtifactId(), jarInfo.getVersion());
    }

}
