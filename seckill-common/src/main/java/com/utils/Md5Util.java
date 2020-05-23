package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 12:40
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class Md5Util {

    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     */
    public static String md5(String text, String key){
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            return true;
        }
        return false;
    }
}
