package com.kedom.productService.util;

public class LuaClass {
    public static final String verifyAPI = "local code = redis.call('GET', KEYS[1]);\n" +
            "if(code==ARGV[1])\n" +
            "then\n" +
            "    redis.call('del', KEYS[1]);\n" +
            "    return true\n" +
            "end\n" +
            "return false;";
}
