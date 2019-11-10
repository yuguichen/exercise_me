package 笔试.快手;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] s = in.nextLine().split(" ");
        int[] a = new int[s.length];
        for(int i=0;i<a.length;i++){
            a[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);
        System.out.println(0);
    }

}
