package test;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Demo {

    public static void main(String[] args) {
        List<Integer> movies = new ArrayList<>();
        movies.add(new Integer(1));
        movies.add(new Integer(2));

//        List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
//        for(int id : movieIds) {
//            System.out.println(id);
//        }

        System.out.println(StringUtils.join(movies, ",").toString());
    }

    public static boolean isBitNZ(int i, int pos) {
        return i > 0 && pos > 0 && (i & 1 << pos - 1) > 0;
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
