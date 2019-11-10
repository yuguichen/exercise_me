package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Demo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));

    }

    /**
     * 将日期字符串转换为以下格式日期
     *      yyyy-MM-dd HH:mm:ss、yyyy-MM-dd HH:mm、yyyy-MM-dd
     * @param timeString
     * @return
     */
    public static String handleTime(String timeString){
        String time = null;
        SimpleDateFormat sDateFormat = null;
        int length = timeString.length();

        if(length == 19){
            if(timeString.contains("-"))
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(timeString.contains("/")){
                sDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            }
            try {//必须捕获异常
                Date date = sDateFormat.parse(timeString);
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(length == 16){
            if(timeString.contains("-"))
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if(timeString.contains("/")){
                sDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            }
            try {
                Date date = sDateFormat.parse(timeString);
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if( length == 10){
            if(timeString.contains("-"))
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(timeString.contains("/") )
                sDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = sDateFormat.parse(timeString);
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return time;
    }


    /**
     * 将日期字符串转换为以下格式日期
     *      yyyy-MM-dd HH:mm:ss、yyyy-MM-dd HH:mm、yyyy-MM-dd
     * @param timeString
     * @return
     */
    public static String handleTime2(String timeString){
        String time = null;

        timeString = timeString.replaceAll("[/]","-");
        timeString = timeString.replaceAll("[-][0-9][-]","-0"+timeString.charAt(5)+"-");
        timeString = timeString.replaceAll("[-][0-9][\\s]","-0"+timeString.charAt(8)+" ");
        timeString = timeString.replaceAll("[\\s][0-9][:]"," 0"+timeString.charAt(11)+":");
        timeString = timeString.replaceAll("[:][0-9][:]",":0"+timeString.charAt(14)+":");
        timeString = timeString.replaceAll("[:][0-9]$",":0"+timeString.charAt(17));

        SimpleDateFormat sDateFormat;
        int length = timeString.length();
        if(length == 19){
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {//必须捕获异常
                Date date = sDateFormat.parse(timeString);
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(length == 16){
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date date = sDateFormat.parse(timeString);
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if( length == 10){
            sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sDateFormat.parse(timeString);
                time = sDateFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return time;
    }


}
