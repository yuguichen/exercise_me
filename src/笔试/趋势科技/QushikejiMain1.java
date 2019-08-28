package 笔试.趋势科技;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求两个数字字符串之和（1-200位）
 */
public class QushikejiMain1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);

    }

    /**
     * 9234567890123456789012345678901234567890.1234567890123456789012345678901234567890
     * 1000000000100000000010000000001000000000.9000000000100000000010000000001000000000
     * @param num1
     * @param num2
     * @return
     */
    private static String add(String num1, String num2) {
        //Please write your code here
        String[] a = num1.split("\\.");
        String[] b = num2.split("\\.");

        String result_z = "";
        String result_x = "";

        if(a.length != b.length){
            if(a.length==2)
                result_x = a[1];
            else
                result_x = b[1];
            result_z = addZheng(a[0],b[0],false);
            return result_z+"."+result_x;
        } else if(a.length==1){
            return addZheng(a[0],b[0],false);
        } else{
            result_x =addXiao(a[1],b[1]);
            result_z = addZheng(a[0],b[0],result_x.contains("."));
            if(result_x.contains("."))
                result_x = result_x.substring(2,result_x.length());
            return result_z+"."+result_x;
        }

    }

    /**
     * 小数部分相加
     * @param num1
     * @param num2
     * @return
     */
    private static String addXiao(String num1, String num2){
        boolean jinweiFlag = false;
        String result_x = "";

        // 补齐
        if(num2.length()>num1.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num1.length()>num2.length()){
            result_x = num1.substring(num2.length(),num1.length());
            num1 = num1.substring(0,num2.length());
        }

        int length = num2.length();
        for(int i=0; i<length; i++){
            int aa = Integer.parseInt(num1.substring(length-i-1,length-i));
            int bb = Integer.parseInt(num2.substring(length-i-1,length-i));

            int result = aa+bb;
            if(jinweiFlag){
                result++;
                jinweiFlag = false;
            }
            if(result>=10){
                jinweiFlag = true;
            }
            String res =  String.valueOf(result%10);
            result_x = res+result_x;
        }
        if(jinweiFlag)
            result_x = "1."+result_x;

        return result_x;
    }

    /**
     * 整数部分相加
     * @param num1
     * @param num2
     * @return
     */
    private static String addZheng(String num1, String num2, boolean flag){
        boolean jinweiFlag = flag;
        String result_z = "";
        String pre = "";

        // 整数部分
        if(num2.length()>num1.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num1.length()>num2.length()){
            pre = num1.substring(0,num1.length()-num2.length());
            num1=num1.substring(num1.length()-num2.length(),num1.length());
        }
        int length = num1.length();

        for(int i=0; i<length; i++){
            int aa = Integer.parseInt(num1.substring(length-i-1,length-i));
            int bb = Integer.parseInt(num2.substring(length-i-1,length-i));

            int result = aa+bb;
            if(jinweiFlag){
                result++;
                jinweiFlag = false;
            }
            if(result>=10){
                jinweiFlag = true;
            }
            String res = String.valueOf(result%10);
            result_z = res+result_z;
        }

        if(pre.length()>0 ){
            if(jinweiFlag){
                int len = pre.length();
                int t = Integer.parseInt(pre.substring(len-1,len))+1;
                pre = pre.substring(0,len-1)+String.valueOf(t);
            }
            result_z = pre+result_z;
            return result_z;
        }

        if(jinweiFlag){
            result_z = "1"+result_z;
        }
        return result_z;
    }
}
