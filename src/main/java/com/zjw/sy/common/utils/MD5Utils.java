package com.zjw.sy.common.utils;

import java.security.MessageDigest;

/**
 * Description MD5加密类
 *
 * @author ZhengJiawei
 * @date 2019-03-19 10:07:46
 */
public final class MD5Utils {

    /**
     * Description Md5加密
     *
     * @param s
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-19 10:08:01
     */
    public final static String md5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5Utils");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.md5("123"));
    }
}
