package com.utils;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 13:00
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class Exceptions {

    public static RuntimeException unchecked(Throwable ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        } else {
            return new RuntimeException(ex);
        }
    }

}
