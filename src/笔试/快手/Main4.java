package 笔试.快手;


import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N <= 2)
            System.out.println(N);
        else {
            in.nextLine();
            String[] s = in.nextLine().trim().split(" ");
            int[] a = new int[s.length];
            for(int i=0;i<a.length;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(a);
            System.out.println(solution(a,N));
        }
    }

    public static int solution(int[] a,int N){
        if(a.length == 0)
            return 0;
        int len = a[N-1]-a[0]+1;
        int[][] dp = new int[N][len];
        int result = 1;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<i;j++){
                int temp = a[i]-a[j];
                if(dp[j][temp]>0)
                    dp[i][temp] = dp[j][temp]+1;
                else
                    dp[i][temp] = 2;
                result = Math.max(result,dp[i][temp]);
            }
        }
        return result;
    }
}
