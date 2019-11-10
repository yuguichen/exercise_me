package 笔试.Vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        int n = input[0];
        int m = input[1];

        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        int num = 1;
        int index = 1;
        int size = list.size();
        List<Integer> temp = new ArrayList<>();
        while(!list.isEmpty()){
            if(list.size() == 1){
                stringBuilder.append(list.get(0));
                break;
            }

            if(num%m == 0){
                stringBuilder.append(list.get(index-1));
                stringBuilder.append(" ");
                temp.add(list.get(index-1));
                //list.remove(index-1);
            }
            num++;
            index++;
            if(index>size){
                index=1;
                list.removeAll(temp);
                size = list.size();
                temp = new ArrayList<>();
            }
        }

        return stringBuilder.toString().trim();
    }



}
