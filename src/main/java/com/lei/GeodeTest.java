package com.lei;

import java.util.Map;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.*;

public class GeodeTest {
    public static void main(String[] args) throws Exception {
        ClientCache cache = new ClientCacheFactory()
                .addPoolLocator("localhost", 9009)
                .create();
        Region<String, Integer> region = cache
                .<String, Integer>createClientRegionFactory(ClientRegionShortcut.PROXY)
                .create("hello");

        for (int i = 0; i < 5 * 100 * 100 * 100; i++) {
            region.put("1", 1);
            region.put("2", 1);
        }

        for (Map.Entry<String, Integer> entry : region.entrySet()) {
            System.out.format("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }
        cache.close();
    }
}
