package 笔试.五八同城;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] req = new int[200];
        for(int i=0;i<200;i++){
            req[i] = in.nextInt();
        }

        Arrays.sort(req);

        System.out.println(req[197]);


    }



}
