package 笔试.iHandy;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];

        int s = in.nextInt();
        while(in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();

            for(int j=a;j<=b;j++){
                arr[j]++;
            }
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr[i]%2 == 1)
                sum++;
        }
        System.out.println(sum);

    }


}
