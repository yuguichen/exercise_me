package 笔试.远景;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int[] price = new int[s.length];

        for(int i=0;i<price.length;i++){
            price[i] = Integer.parseInt(s[i]);
        }

        int result = maxLose(price);
        System.out.println(result);
    }

    public static int maxLose(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int maxLose = 0;
        int i;
        for(i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                maxLose = prices[i-1]-prices[i]+maxLose;
            }
        }
        return maxLose;
    }


}
