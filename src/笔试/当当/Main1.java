package 笔试.当当;

import java.util.Scanner;


public class Main1 {

    public static String[] danwei_L = {"","拾","佰","仟"};
    public static String[] danwei_H = {"","万","亿","万亿"};
    public static char[] shuzi = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();

        long n = 1409000294;
        String result = "元";

        int l=0;
        int h=0;
        boolean flag = false;
        while(n!=0){
            StringBuilder stringBuilder = new StringBuilder();
            int num = (int) n%10;
            n/=10;
            if(num != 0){
                stringBuilder.append(shuzi[num]);
                stringBuilder.append(danwei_L[l++]);
                flag = true;
            } else if(flag){
                stringBuilder.append(shuzi[num]);
                l++;
            } else{
                l++;
            }

            stringBuilder.append(result);
            result = stringBuilder.toString();
            if(l==danwei_L.length) {
                l = 0;
                h++;
                result = danwei_H[h]+result;
                flag = false;
            }
        }
        result = result.replaceAll("零+","零");
        System.out.println(result);
    }


}
