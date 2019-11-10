package javaSE.src2;
import java.util.Date;

public class String_Demo1 {
    public static void main(String args[]) {
        //String s1 ="aacd";
        //String s2 =  "abcde";
        //String s = s1 + s2;
        //System.out.println(s1 ==s2);
        //System.out.println(s.indexOf('c'));
        //System.out.println(s1.trim().length());
       // System.out.println(s1.toUpperCase());
//        Date date= new Date();
//        String year=String.format("%tY",date);
//        String month=String.format("%tB",date);
//        System.out.println("今年是："+year+"年");
//        System.out.println("xianzai是："+month);
//        System.out.println(date.getTime());
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2  = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
