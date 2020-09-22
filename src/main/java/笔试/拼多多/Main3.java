package 笔试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);



    }

}
