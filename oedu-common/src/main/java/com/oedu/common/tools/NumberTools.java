package com.oedu.common.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberTools {

    /**
     * 格式化千位符，保留两位小数，不足补0
     * @param d
     * @return
     */
    public static String getThousandSeparator(double d) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        return new DecimalFormat("#,##0,00").format(bigDecimal);
    }

    public static double add(double d, double d2) {
        return BigDecimal.valueOf(d).add(BigDecimal.valueOf(d2)).doubleValue();
    }

    public static double subtract(double d, double d2) {
        return BigDecimal.valueOf(d).subtract(BigDecimal.valueOf(d2)).doubleValue();
    }

    public static double multiply(double d, double d2) {
        return BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(d2)).doubleValue();
    }

    /**
     * 四位精度的四舍五入的除法
     * @param d
     * @param d2
     * @return
     */
    public static double divide(double d, double d2) {
        return BigDecimal.valueOf(d).divide(BigDecimal.valueOf(d2),4,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
