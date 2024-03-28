package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticFormBody;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.annotations.URLEncoder;

@URLEncoder
public interface Test2Api {


    @StaticQuery(value="timestamp=2024-03-25 13:10:29", urlEncode = true)
    @StaticFormBody("param_json=%7B%22isvGoodsNo%22%3A%22771100RAUL4494%22%2C%22deptNo%22%3A%22ET0596%22%2C%22barcodes%22%3A%22771100RAUL4494%22%2C%22thirdCategoryNo%22%3A%22%22%2C%22goodsName%22%3A%22%E3%80%90BG%E4%B8%93%E7%94%A8%E3%80%91%E4%BA%AC%E4%B8%9C-%E6%83%A0%E5%AF%BB%2B%E4%BA%AC%E4%B8%9C%E8%87%AA%E6%9C%89%E5%93%81%E7%89%8C%20%E6%B3%A1%E6%B2%AB%E6%B4%97%E6%89%8B%E6%B6%B2500ml%20%E6%8A%91%E8%8F%8C99.9%25%20%E6%A9%99%E8%8A%B1%E9%A6%99%20%E7%BB%86%E8%85%BB%20%E9%95%BF%E6%95%88%E5%80%8D%E6%8A%A4%28100032516393%29%5BVOP%5D%22%2C%22brandName%22%3A%22%E6%83%A0%E5%AF%BB%22%2C%22modelNumber%22%3A%22771100RAUL4494%22%2C%22produceAddress%22%3A%22%E6%97%A0%22%2C%22goodsUnit%22%3A%22Pcs%22%2C%22volume%22%3A%22999%22%2C%22grossWeight%22%3A999%2C%22length%22%3A999%2C%22width%22%3A999%2C%22height%22%3A999%2C%22exportcarton%22%3Anull%2C%22customMade%22%3A%221%22%2C%22serial%22%3A%22BATCH%22%2C%22shelfLife%22%3A3650%2C%22unicodeType%22%3A%22%22%2C%22receiptValidate%22%3A%22N%22%2C%22receiptCollect%22%3A%22N%22%2C%22issueValidate%22%3A%22N%22%2C%22issueCollect%22%3A%22N%22%7D")
    @Post("http://edi04-uat.kerrylogistics.com/HTTPIncomingEDIfile/sync/formbody/TENCENTWK3/SKU?app_key=tencent2824323&method=kr.goods.in.request&sign=FBC5A871C8CAE6A10E16063B8B606139&v=1")
    Response test();
}
