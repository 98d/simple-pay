package com.simple.utils;

/**
 * Created by Jin.Z.J  2020/11/26
 */
public class StringUtils {


    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }


    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


}
