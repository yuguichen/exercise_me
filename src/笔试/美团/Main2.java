package 笔试.美团;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        int[] a = new int[n];
//        String str = in.nextLine();
//        str=in.nextLine();
//
//        String[] num = str.split("\\s");
//        for(int j = 0;j<n;j++){
//            a[j] = Integer.parseInt(num[j]);
//        }
        int n= 9;
        int[] a ={1, 3 ,4,5, 7, 2, 6, 5, 12, 32};

        int[] result = solution(n,a);

        System.out.println(result[0]+" "+result[1]);

    }

    public static int[] solution(int n, int[] a){
        int[] result = {a[0],a[1]};
        int res = Math.abs(a[0]-a[1]);
        for(int i=0;i<n-1;i++){
            int temp = Math.abs(a[i]-a[i+1]);
            System.out.println(temp);
            if(res>temp){
                res = temp;
                result[0] = a[i];
                result[1] = a[i+1];
            }
        }
        return result;
    }
}
