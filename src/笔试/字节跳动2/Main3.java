package 笔试.字节跳动2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] juzhen = new int[n][n];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                juzhen[i][j] = sc.nextInt();
            }
        }

        solution(juzhen,n);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(juzhen[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solution(int[][] juzhen,int n){
        int length = 4;
        if(n==1){
            for(int i=0;i<2;i++){
                for(int j = 0;i<4;j++){

                    if(juzhen[i*2][j] == juzhen[i*2+1][j] && juzhen[i*2][j]!=0 && juzhen[i*2+1][j]!=0)
                        juzhen[i][j] = juzhen[i*2][j]+juzhen[i*2+1][j];

                }
            }
            for(int i= 2; i<4;i++){
                for(int j = 0;i<4;j++){
                    juzhen[i][j] = 0;
                }
            }
        }
        if(n==2){

        }
        if(n==3){

        }
        if(n==4){

        }
    }
}
