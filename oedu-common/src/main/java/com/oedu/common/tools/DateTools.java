package com.oedu.common.tools;

import com.oedu.common.Contants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTools {

//    public static String getCurrentDate1() {
//        return LocalDate.now().format(DateTimeFormatter.ofPattern(Contants.DATE_FORMATE_1));
//    }
//
//    public static String getCurrentDate2() {
//        return LocalDate.now().format(DateTimeFormatter.ofPattern(Contants.DATE_FORMATE_2));
//    }
//
//    public static String getCurrentDateTime1() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Contants.DATETIME_FORMATE_1));
//    }
//
//    public static String getCurrentDateTime2() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Contants.DATETIME_FORMATE_2));
//    }

    public static LocalDateTime getDateByString(String date, String pattern) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static String dateformate_1(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(Contants.DATE_FORMAT_1));
    }

    public static String dateformate_2(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(Contants.DATE_FORMAT_2));
    }

    public static String dateTimeformate_1(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(Contants.DATETIME_FORMAT_1));
    }

    public static String dateTimeformate_2(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(Contants.DATETIME_FORMAT_2));
    }



}
