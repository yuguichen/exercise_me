package javaSE.src2;

import java.text.DecimalFormat;

public class DecimalFormat_Demo1 {
    public static void main(String args[]){
         SimgleFormat("###,###.###",123456.789);
         SimgleFormat("00000000.###kg",123456.789);

         SimgleFormat("000000.000",123.78);

         UseApplyPatternMethodFormat("#.###%",0.789);

         UseApplyPatternMethodFormat("###.##",123456.789);

         UseApplyPatternMethodFormat("0.00\u2030",0.789);
    }

    public static void SimgleFormat(String pattern,double value){
        DecimalFormat myformat=new DecimalFormat(pattern);
        String output = myformat.format(value);
        System.out.println(value+"  "+pattern+"  "+output);
    }

    public static void UseApplyPatternMethodFormat(String pattern,double value){
        DecimalFormat myformat=new DecimalFormat();
         myformat.applyPattern(pattern);
        System.out.println(value+"  "+pattern+"  "+myformat.format(value));
    }

}
