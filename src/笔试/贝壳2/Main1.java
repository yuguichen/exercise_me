package 笔试.贝壳2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int S = in.nextInt();
        int[] c = new int[n];
        for(int i=0; i<n; i++){
            c[i] = in.nextInt();
        }

        Arrays.sort(c);
        int result = 0;
        for(int i=0;i<n;i++){
            if(S>=c[i]){
                result++;
                S-=c[i];
            }
            if(S<=0)
                break;
        }
        System.out.println(result);
    }


}
