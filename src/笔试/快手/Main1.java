package 笔试.快手;

import java.util.Scanner;

public class Main1 {

    private static final String[] result = {"IPv4","IPv6","Neither"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean flag = true;
        if(s.contains(".")){
            String[] ss = s.split("\\.");
            for(int i=0;i<ss.length;i++){
                Integer temp = Integer.parseInt(ss[i]);
                if((temp>0 && temp<=255 && ss[i].charAt(0)!='0')
                        || (temp ==0 && ss[i].length()==1))
                    continue;
                else{
                    flag = false;
                    break;
                }
            }
            if(flag && ss.length == 4){
                System.out.println(result[0]);
            } else{
                System.out.println(result[2]);
            }
        } else if(s.contains(":")){
            String[] ss = s.split(":");
            if(s.contains("::") || ss.length!=8)
                System.out.println(result[2]);
            else {
                for(int i=0;i<ss.length;i++){
                    String temp = ss[i];
                    if(temp.equals("0000")){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag ){
                System.out.println(result[1]);
            } else{
                System.out.println(result[2]);
            }
        } else {
            System.out.println(result[2]);
        }
    }

}