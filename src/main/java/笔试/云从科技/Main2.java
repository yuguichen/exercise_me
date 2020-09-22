package 笔试.云从科技;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String[] ss = s.split(",");
        int[] arr = new int[ss.length];
        for(int i=0;i<ss.length;i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        maoPao(arr);


    }

    public static void maoPao(int[] arr){
        int len = arr.length;
        for(int i=0; i<len; i++){
            for(int j=len-1; j>i; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
            System.out.print(arr[i]);
            if(i<len-1)
                System.out.print(",");
        }
    }


    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
