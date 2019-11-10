package 笔试.远景;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        int[][] arr = new int[M][N];
        for(int i=0;i<M;i++){
            String[] line = in.nextLine().split(",");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = solution(arr,M,N);
        System.out.println(result);
    }

    public static int solution(int[][] arr,int M, int N){
        int result = 0;
        boolean[][] marked = new boolean[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!marked[i][j] && arr[i][j]==1){
                    result = Math.max(result,bfs(arr,i,j,marked,0)) ;
                }
            }
        }
        return result;
    }
    public static int bfs(int[][] arr,int i, int j, boolean[][] marked,int sum){
        sum++;
        marked[i][j] = true;

        if(i-1>=0 && arr[i-1][j]==1 && !marked[i-1][j])
            sum = bfs(arr,i-1,j,marked,sum);
        if(i+1<arr.length && arr[i+1][j]==1 && !marked[i+1][j])
            sum = bfs(arr,i+1,j,marked,sum);

        if(j-1>=0 && arr[i][j-1]==1 && !marked[i][j-1])
            sum = bfs(arr,i,j-1,marked,sum);
        if(j+1<arr[0].length && arr[i][j+1]==1 && !marked[i][j+1])
            sum = bfs(arr,i,j+1,marked,sum);

        return sum;
    }


}
