package com.pzh.mall.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 14:03
 * @Version 1.0
 */
public class MD5Utils {
    private static final String SALT = "EF2d.shr";

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String username, String pwd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pwd, ByteSource.Util.bytes(username + SALT), HASH_ITERATIONS).toHex();
        return newPassword;
    }
}
