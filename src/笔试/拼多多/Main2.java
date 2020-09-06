package 笔试.拼多多;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] flag = new boolean[n];

        int ans = 0;
        for(int i=0;i<m;i++){
            int li = in.nextInt()-1;
            int hi = in.nextInt()-1;
            int sum = 0;
            for(int j = li;j<=hi;j++){
                if(!flag[j]){
                    sum++;
                    flag[j] = true;
                }
            }
            ans+=sum;
            System.out.println(ans);
        }


    }
}


