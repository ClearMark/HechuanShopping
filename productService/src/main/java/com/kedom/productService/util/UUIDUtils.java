package com.kedom.productService.util;

import java.util.UUID;

public class UUIDUtils {

    public UUIDUtils() {
    }

    public static String getId() {
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}

