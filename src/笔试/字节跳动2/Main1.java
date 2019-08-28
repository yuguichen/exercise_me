package 笔试.字节跳动2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       // int n = sc.nextInt();
        int n =1;
        int k = n;
        int[][] hudong = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                hudong[i][j] = 0;
            }
        }

        for(int i=0;i<n-1;i++){
            k= k - dfs(hudong,n,i)+1;
        }

        if(n == 1)
            System.out.println(n);
        else
            System.out.println(k);
    }

    public static int dfs(int[][] hudong,int n,int index){
        int k = 1;

        if(index+1>=n)
            return k;

        for(int j = index+1;j<n;j++){
            if(hudong[index][j]>=3){
                hudong[index][j] = 0;
                hudong[j][index] = 0;
                k=dfs(hudong,n,j)+k;
            }
        }
        return k;
    }
}
