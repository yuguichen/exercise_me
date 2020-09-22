package 笔试.贝壳2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将一组数分两组，在保证两组数之和的差值最小的前提下，两组元素的数量差值最大是多少？
 * 未解决
 */
public class Main4 {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] w = new int[n];
//        for(int i=0; i<n; i++){
//            w[i] = in.nextInt();
//        }

        int[] w = {3,8,2,9,4,3,27,5,32,18,75,24,98,31,29,10,84,20,23,105};
        int n = w.length;
        Arrays.sort(w);
        for(int i=0;i<n;i++){
            System.out.print(w[i]+" ");
        }
        System.out.println();

        int left = 0;
        int leftIndex = 0;
        int right = 0;
        int rightIndex = 0;
        for(int i=n-1;i>=0;i--){
            if(right>left){
                left+=w[i];
                System.out.print(w[i]+" ");
                leftIndex++;
            } else{
                right+=w[i];
                rightIndex++;
            }

        }
        System.out.println();
        System.out.println(left+" "+right+ " ");
        System.out.println(leftIndex+" "+rightIndex+ " ");

    }



}
