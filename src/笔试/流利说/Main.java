package 笔试.流利说;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 车站调度问题：
 *      根据列车到站时刻，确定最少站台数；
 */
public class Main {

    public static void main(String[] args) {
        int[] start = {900,940,950,1100};
        int[] end = {910,1200,1120,1130};
        int result = findNum(start,end);
        System.out.println(result);
    }

    public static void solution(){
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }

        int num = list.size()/2;
        int[] start = new int[num];
        int[] end = new int[num];
        int index = 0;
        for(Integer i:list){
            if(index<num){
                start[index++] = i;
            } else {
                end[index-num] = i;
                index++;
            }
        }

        int result = findNum(start,end);
        System.out.println(result);
    }

    public static int findNum(int[] start, int[] end){
        int length = start.length;
        int[] temp = new int[length];
        int result = 0;

        for(int i=0;i<length;i++){
            if(temp[i] > 0)
                continue;

            result++;
            temp[i] = result;
            int tempEnd = end[i];

            for(int j=i+1;j<length;j++){
                if(start[j]>=tempEnd){
                    temp[j] = result;
                    tempEnd = end[j];
                }
            }
        }

        return result;
    }



}
