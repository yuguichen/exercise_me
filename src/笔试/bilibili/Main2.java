package 笔试.bilibili;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
        //int N = in.nextInt();
        int result = solution2(3);
        System.out.println(result);
    }

    public static int solution(int N){
        int result = 0;
        for(int i=1;i<=N/2;i++){
            int sum = 0;
            int j = 0;
            for(j=i;sum<N;j++){
                sum +=j;
            }
            if(sum == N){
                result++;
            }

        }
        return result+1;
    }

    public static int solution2(int N){
        if(N<=2)
            return 1;

        int result = 0;
        for(float i=2;i<=(N/2);i++){
            float temp = N/i + 0.5f-i/2;

            if((int)temp == temp){
                result++;
            }
        }
        return result;

    }

}
