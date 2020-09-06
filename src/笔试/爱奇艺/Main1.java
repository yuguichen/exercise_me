package 笔试.爱奇艺;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int red = 3;
        int blue = 4;

        float[][] dp = new float[red+1][blue+1];
        for(int i=0;i<=red;i++){
            dp[i][0] = 1.0f;
        }
        for(int i=0;i<=blue;i++){
            dp[0][i] = 0.0f;
        }

        for(int i=1;i<=red;i++){
            for(int j=1;j<=blue;j++){
                dp[i][j] = (float) i/(i+j);
                if(j>=3)
                    dp[i][j] += (float)(j*(j-1)*(j-2))/((i+j)*(i+j-1)*(i+j-2))*dp[i][j-3];
                if(i>=1 && j>=2)
                    dp[i][j] += (float)(i*j*(j-1))/((i+j)*(i+j-1)*(i+j-2))*dp[i-1][j-2];
            }
        }

        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println(df.format(dp[red][blue]));
    }




}
