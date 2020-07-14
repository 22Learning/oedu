package com.oedu.common.tools;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static List filterNull(List<Object> list) {
        if (isEmpty(list)) {
            return list;
        }
        return list.stream().filter(o -> o != null).collect(Collectors.toList());
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }
}
