package org.msy.boot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static String format = "yyyy-MM-dd";

    private static SimpleDateFormat sdf = new SimpleDateFormat(format);

    public static Date strToDate(String d) {
        if(d == null) return null;
        Date parse = null;
        try {
            parse = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }



}
