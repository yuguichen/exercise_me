package 笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            long[] arr = new long[n];
            for(int j=0;j<n;j++){
                arr[j] = in.nextLong();
            }
            Arrays.sort(arr);

            long one = 0L;
            long other = 0L;
            int j =n-1;

            while(j>=0){
                if(one>other){
                    other+=arr[j--];
                    if(j>=0)
                        one+=arr[j--];
                } else{
                    one+=arr[j--];
                    if(j>=0)
                        other+=arr[j--];
                }
            }

            if(other>one){
                System.out.print(one);
                System.out.print(" ");
                System.out.println(other);
            } else{
                System.out.print(other);
                System.out.print(" ");
                System.out.println(one);
            }

        }
    }

}
