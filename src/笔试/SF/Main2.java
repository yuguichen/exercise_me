package 笔试.SF;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] time = "0010:00A".split(":");

        List<Integer> list = solution(time);

        if(list.size() == 0)
            System.out.println(-1);
        else {
            String s = "";
            for(Integer i:list){
                s+=(i+" ");
            }
            System.out.println(s.trim());
        }

    }

    public static List<Integer> solution(String[] time){
        List<Integer> list = new ArrayList<>();

        String hour = time[0];
        String min = time[1];
        while (hour.length()>0 && hour.charAt(0)== '0'){
            hour = hour.substring(1,hour.length());
        }
        while (min.length()>0 && min.charAt(0)== '0'){
            min = min.substring(1,min.length());
        }

        boolean flag = false;
        // 判断是否所有进制都符合
        if(hour.length()>1 ||  hour.length()==1 && (hour.charAt(0)>'9'||hour.charAt(0)<'0')){
            flag = true;
        }
        if(min.length()>1 ||  min.length()==1 && (min.charAt(0)>'9'||min.charAt(0)<'0')){
            flag = true;
        }
        if(!flag){
            list.add(0);
            return list;
        }

        int n = 2;// 从2进制开始
        while(true){

            int temp1 = changeNtoTen(hour,n,"hour");
            int temp2 = changeNtoTen(min,n,"min");

            if(temp1>1 ||temp2>1)
                n = Math.max(temp1,temp2);
            else if(temp1==0 && temp2==0){
                list.add(n);
                n++;
            } else {
                break;
            }
        }

        return list;
    }

    public static int changeNtoTen(String time, int n,String reg){
        int timeInTen =0;
        boolean flag = false;

        for(int i=0;i<time.length();i++){
            char a = time.charAt(i);
            int t = 0;
            if(a>='0'&&a<='9'){
                t = a-'0';
            } else{
                t = a-'A'+10;
            }

            if(t/10>=n || t%10>=n){
                n = Math.max(t/10,t%10)+1;
                flag  = true;
                break;
            }

            if(t<10){
                timeInTen = timeInTen*n+t;
            } else {
                timeInTen = timeInTen*n+t/10;
                timeInTen = timeInTen*n+t%10;
            }
        }

        if(flag)
            return n;
        else if((reg.equals("hour") && timeInTen<24)||(reg.equals("min") && timeInTen<60))
            return 0;
        else
            return 1;
    }
}
