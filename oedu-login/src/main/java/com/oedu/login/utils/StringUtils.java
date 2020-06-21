package com.oedu.login.utils;

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
}
