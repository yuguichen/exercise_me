package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * handleTimeFormat:将日期字符串转换为以下格式 : yyyy-MM-dd HH:mm:ss、yyyy-MM-dd
     * HH:mm、yyyy-MM-dd、HH:mm:ss、 HH:mm
     *
     * @param timeString
     * @return
     */
    public static String handleTimeFormat(String timeString) {
        String time = null;

        timeString = timeString.trim();
        if (timeString.contains("/") || timeString.contains("-")) {
            timeString = timeString.replaceAll("[/]", "-");

            if (timeString.indexOf("-") == 2)
                timeString = "20" + timeString;

            if (timeString.length() == 6)
                timeString = timeString.replaceAll("[-][0-9]$", "-0" + timeString.charAt(5));
            if (timeString.length() > 6)
                timeString = timeString.replaceAll("[-][0-9][-]", "-0" + timeString.charAt(5) + "-");

            if (timeString.length() == 9)
                timeString = timeString.replaceAll("[-][0-9]$", "-0" + timeString.charAt(8));
            if (timeString.length() > 9)
                timeString = timeString.replaceAll("[-][0-9][\\s]", "-0" + timeString.charAt(8) + " ");
        }

        if (timeString.length() > 10) {
            if (timeString.length() == 12)
                timeString = timeString.replaceAll("[\\s][0-9]$", " 0" + timeString.charAt(11));
            if (timeString.length() > 12)
                timeString = timeString.replaceAll("[\\s][0-9][:]", " 0" + timeString.charAt(11) + ":");

            if (timeString.length() == 15)
                timeString = timeString.replaceAll("[:][0-9]$", ":0" + timeString.charAt(14));
            if (timeString.length() > 15)
                timeString = timeString.replaceAll("[:][0-9][:]", ":0" + timeString.charAt(14) + ":");

            if (timeString.length() == 18)
                timeString = timeString.replaceAll("[:][0-9]$", ":0" + timeString.charAt(17));
        }

        // 处理 HH:mm:ss
        if (timeString.length() < 8 && timeString.contains(":")) {
            timeString = timeString.replaceAll("^[0-9][:]", "0" + timeString.charAt(0) + ":");

            if (timeString.length() == 4)
                timeString = timeString.replaceAll("[:][0-9]$", ":0" + timeString.charAt(3));
            if (timeString.length() > 4)
                timeString = timeString.replaceAll("[:][0-9][:]", ":0" + timeString.charAt(3) + ":");

            if (timeString.length() >= 7)
                timeString = timeString.replaceAll("[:][0-9]$", ":0" + timeString.charAt(6));
        }

        return timeString;
    }

    /**
     * parseTimeString2Date：将时间字符串转换为时间
     *
     * @param timeString
     * @return
     */
    public static Date parseTimeString2Date(String timeString) {
        Date date = null;

        SimpleDateFormat sDateFormat = getSimpleDateFormat(timeString);
        try {// 必须捕获异常
            if (sDateFormat != null) {
                date = sDateFormat.parse(timeString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * HandletimeStringFormat: 处理时间字符串
     *
     * @param timeString
     * @return
     */
    public static String HandletimeStringFormat(String timeString) {
        String time = null;

        SimpleDateFormat sDateFormat = getSimpleDateFormat(timeString);
        try {// 必须捕获异常
            if (sDateFormat != null) {
                Date date = sDateFormat.parse(timeString);
                time = sDateFormat.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static SimpleDateFormat getSimpleDateFormat(String timeString) {

        timeString = handleTimeFormat(timeString);
        SimpleDateFormat sDateFormat = null;
        int length = timeString.length();
        if (length == 19)
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (length == 16)
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (length == 13)
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        if (length == 10)
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (length == 8)
            sDateFormat = new SimpleDateFormat("HH:mm:ss");
        if (length == 7)
            sDateFormat = new SimpleDateFormat("yyyy-MM");
        if (length == 5)
            sDateFormat = new SimpleDateFormat("HH:mm");
        if (length == 4)
            sDateFormat = new SimpleDateFormat("yyyy");

        return sDateFormat;
    }
}
