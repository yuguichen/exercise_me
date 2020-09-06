package 笔试.字节跳动3;

import java.util.Scanner;

/**
 * 小于N的质数
 */
public class Main4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int result = solution(n);
            System.out.println(result);
        }
    }

    public static int solution(int n) {
        if(n <= 1)
            return 0;

        boolean[] flag=new boolean[n];
        int count=0;
        for (int i = 2; i < n; i++) {
            if (flag[i]==false){
                count++;
                for (int j = i; (j*i>0 && j*i < n); j++) {
                    flag[j*i]=true;
                }
            }
        }
        return count;
    }
}
