package io.github.lucklike;

import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.common.DateUtils;
import com.luckyframework.spel.ParamWrapper;
import com.luckyframework.spel.SpELRuntime;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 15:09
 */
public class Main {

    public static void main(String[] args) throws Exception {
        userInfoTest();
    }


//    private static void webSocketTest() throws URISyntaxException {
//        URI wsURI = new URI("ws://localhost:8081/websocket");
//        WebSocketClient client = new WebSocketClient(wsURI) {
//            @Override
//            public void onOpen(ServerHandshake serverHandshake) {
//
//            }
//
//            @Override
//            public void onMessage(String s) {
//                System.out.println("receive message: " + s);
//            }
//
//            @Override
//            public void onClose(int i, String s, boolean b) {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        };
//
//        client.connect();
//        for(;;) {
//            client.send("hello" + DateUtils.showtime());
//        }
//    }

    private static void spELTest() throws NoSuchMethodException {
        //定义2个函数,registerFunction和setVariable都可以，不过从语义上面来看用registerFunction更恰当
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt1", parseInt);
        context.setVariable("parseInt2", parseInt);


        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("#parseInt1('3')").getValue(context, int.class));
        System.out.println(parser.parseExpression("#parseInt2('3')").getValue(context, int.class));

        String expression1 = "#parseInt1('3') == #parseInt2('3')";
        boolean result1 = parser.parseExpression(expression1).getValue(context, boolean.class);
        System.out.println(result1);

        SpELRuntime spELRuntime = new SpELRuntime();
        Map<String, Object> rootMap = new HashMap<>();
        rootMap.put("toInt", parseInt);

        Object parseInt2 = spELRuntime.getValueForType(new ParamWrapper("")
                        .setRootObject(rootMap)
                .addVariable("parseInt2", parseInt)
                .setExpectedResultType(Object.class));
        System.out.println(parseInt2);
    }

    private static void userInfoTest() {
        // url  object
        URL url = null;

        try {
            // create a URL
            url = new URL(
                    "https://fukang1163%40cairh.com%3Afk%400911%21@glakh.cpetest.cairenhui.com/cpe-view-main-backend#/operator-manage/list");

            // get the  UserInfo
            String _UserInfo = url.getUserInfo();

            // display the URL
            System.out.println("URL = " + url);

            // display the  UserInfo
            System.out.println(" UserInfo="
                    + _UserInfo);
        }
        // if any error occurs
        catch (Exception e) {

            // display the error
            System.out.println(e);
        }
    }
}