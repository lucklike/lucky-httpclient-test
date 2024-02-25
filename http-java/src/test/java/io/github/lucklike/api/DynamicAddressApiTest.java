package io.github.lucklike.api;

import io.github.lucklike.util.Lucky;
import junit.framework.TestCase;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/25 01:11
 */
public class DynamicAddressApiTest extends TestCase {

    private final DynamicAddressApi api = Lucky.createApi(DynamicAddressApi.class);

    public void testGetPageContent() {
        System.out.println(api.getPageContent());
        api.getPageContent();
        api.getPageContent();
    }
}