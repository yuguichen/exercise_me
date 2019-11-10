package 笔试.字节跳动3;

import java.util.Scanner;

/**
 * 逆时针打印数组：从右上角开始
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            StringBuilder stringBuilder = new StringBuilder();


        }

    }

    public static int[] Solution(int[][] arr, int n, int m) {
        int startX = 0;
        int startY = 0;
        int endX = m-1;
        int endY = n-1;
        int index = 0;
        int[] res = new int[n*m];
        while (startX <= endX && startY <= endY) {
            // 上---->下
            if (startY <= endY) {
                for (int i = startY; i <= endY; i++) {
                    res[index++] = arr[i][startX];
                }
            }
            // 左---->右 (两列以上)
            if (startX < endX) {
                for (int i = startX+1; i <= endX; i++) {
                    res[index++] = arr[endY][i];
                }
            }
            // 下---->上(两行两列以上)
            if (startX < endX && startY < endY) {
                for (int i = endY-1; i >= startY; i--) {
                    res[index++] = arr[i][endX];
                }
            }
            // 右---->左(三列两行以上)
            if (startX < endX-1 && startY < endY) {
                for (int i = endX-1; i >= startX+1; i--) {
                    res[index++] = arr[startY][i];
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return res;
    }



}
