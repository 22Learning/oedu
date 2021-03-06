package com.oedu.common.tools;

import java.util.Collection;

public class StringUtils {
    public static boolean isEmptyOrNull(String str){
        if(null == str)
            return true;

        return str.trim().equals("") || str.trim().equalsIgnoreCase("null");
    }

    public static boolean isEmpty(Object obj){
        if(null == obj)
            return true;
        if(obj instanceof Collection){
            return ((Collection) obj).isEmpty();
        }
        if(obj instanceof String){
            return isEmptyOrNull((String) obj);
        }

        return false;
    }

    public static boolean isNotEmptyOrNull(String str){
        return !isEmptyOrNull(str);
    }

    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    public static boolean equals(String a, String b) {
        return org.apache.commons.lang3.StringUtils.equals(a, b);
    }

    public static boolean equalsAny(String a, String... args) {
        return org.apache.commons.lang3.StringUtils.equalsAny(a, args);
    }
}
