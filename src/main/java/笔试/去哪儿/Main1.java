package 笔试.去哪儿;


import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        if(n==1|| n==2)
            System.out.println(arr[n-1]);
        else {
            int temp = arr[0]+2*arr[1];
            while(n>3){
                sum+=(arr[n-1]+temp);
                n-=2;
            }
            for(int i=0;i<n;i++){
                sum+=arr[i];
            }
            System.out.println(sum);

        }


    }

}
