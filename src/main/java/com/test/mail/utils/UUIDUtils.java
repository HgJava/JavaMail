package com.test.mail.utils;

import java.util.UUID;

/**
 * ��ȡ������
 * @author ���ʶ���һ��
 *
 */
public class UUIDUtils {
    public static String getCode() {
    	return UUID.randomUUID().toString().replace("-", "");
    }
}
