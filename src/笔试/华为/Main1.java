package 笔试.华为;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String[] ss = s.split("},");
        ss[0] = ss[0].substring(3,ss[0].length());
        ss[1] = ss[1].substring(3,ss[1].length());
        ss[2] = ss[2].substring(ss[2].length()-1,ss[2].length());

        String[] ss0 = ss[0].split(",");
        String[] ss1 = ss[1].split(",");
        int[] A = new int[ss0.length];
        int[] B = new int[ss1.length];
        int R = Integer.parseInt(ss[2]);

        for(int i=0;i<ss0.length;i++){
            A[i] = Integer.parseInt(ss0[i]);
        }
        for(int i=0;i<ss1.length;i++){
            B[i] = Integer.parseInt(ss1[i]);
        }

        for(int i=0;i<A.length;i++){
            boolean flag = false;
            for(int j=0;j<B.length;j++){
                if(A[i]<=B[j] && B[j]-A[i]<=R){
                    flag = true;
                    System.out.print("("+A[i]+","+B[j]+")");
                } else if(flag){
                    break;
                } else if(A[i]<=B[j]){
                    System.out.print("("+A[i]+","+B[j]+")");
                    break;
                }
            }
        }

    }


}
