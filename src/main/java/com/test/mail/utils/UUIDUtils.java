package com.test.mail.utils;

import java.util.UUID;

/**
 * 获取激活码
 * @author 劳资独宠一方
 *
 */
public class UUIDUtils {
    public static String getCode() {
    	return UUID.randomUUID().toString().replace("-", "");
    }
}
