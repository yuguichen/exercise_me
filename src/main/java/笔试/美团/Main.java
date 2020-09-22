package 笔试.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 黑白矩阵
 *      一个元素的上下左右四个元素均相等，且不等与该元素
 * 给定一个矩阵，将该矩阵修改为黑白矩阵，最少要修改多少元素。
 */
public class Main {
    public static void main(String[] args){
        //输入一串以空格为间隔的数字读取到字符串中，并转化为int[]数组
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] matrix = new int[a][b];
        String str = in.nextLine(); //去除in.nextInt()留下的空白符“\r”
        for(int i=0;i<a;i++){
            str=in.nextLine();
            String[] num = str.split("\\s");
            for(int j = 0;j<num.length;j++){
                matrix[i][j] = Integer.parseInt(num[j]);
            }
        }

        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> second = new HashMap<>();
        for(int i=0;i<a;i++){
            for(int j = 0;j<b;j++){
                //奇数行的偶数列 和 偶数行的奇数列拿出来
                if(( (i+1)%2==1&&(j+1)%2==0)||( (i+1)%2==0&&(j+1)%2==1 )){
                    if(first.containsKey(matrix[i][j]))
                        first.put(matrix[i][j],first.get(matrix[i][j])+1);
                    else
                        first.put(matrix[i][j],1);
                } else {
                    if(second.containsKey(matrix[i][j]))
                        second.put(matrix[i][j],second.get(matrix[i][j])+1);
                    else
                        second.put(matrix[i][j],1);
                }
            }
        }

        int value1 = 0;
        int key1 = 0;
        int temp1 = value1;
        for(Map.Entry<Integer, Integer> entry : first.entrySet()){
            if(entry.getValue()>value1){
                temp1 = value1;
                value1 = entry.getValue();
                key1 = entry.getKey();
            }
        }
        int value2 = 0;
        int key2 = 0;
        int temp2 = value2;
        for(Map.Entry<Integer, Integer> entry : second.entrySet()){
            if(entry.getValue()>value2){
                temp2 = value2;
                value2 = entry.getValue();
                key2 = entry.getKey();
            }
        }
        int result = 0;
        if(key1 == key2){
            if(value1+value2 == a*b)
                result = value1>value2 ? value2:value1;
            else if(value1>value2)
                result = a*b-value1-temp2;
            else
                result = a*b-value2-temp1;
        } else
            result = a*b-value1-value2;
        System.out.println(result);
    }
}
