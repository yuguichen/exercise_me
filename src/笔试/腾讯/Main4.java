package 笔试.腾讯;


import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int index = 0;
        int temp = 0;
        for(int i=0;i<n && index<k;i++){
            int t =arr[i]-temp;
            if(t>0){
                System.out.println(t);
                index++;
                temp = arr[i];
            }
        }

        while(index<k){
            System.out.println(0);
            index++;
        }

    }
}
