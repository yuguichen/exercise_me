package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 判断连续数字长度
 */
public class Test {
    public static void main(String[] args){
        //从控制台输入
        int[] a = getIn();

        ArrayList<int[]> arrayList = solution(a);

        for(int[] array:arrayList){
            System.out.println(array.length);
            for(int i = 0;i<array.length;i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }

    }

    public static int[] getIn(){
        //输入一串以空格为间隔的数字读取到字符串中，并转化为int[]数组
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        String[] numList = str.split("\\s");
        int[] a = new int[numList.length];
        for(int i = 0;i<a.length;i++){
            a[i] = Integer.parseInt(numList[i]);
        }
        return a;
    }

    public static ArrayList<int[]> solution(int[] a){
        ArrayList<int[]> arrayList = new ArrayList();
        String s = "";
        for(int i=0;i<a.length;i++){
            //最后一个元素
            if(i+1 == a.length){
                s+=a[i];
                String[] numList = s.split(",");
                int[] b = new int[numList.length];
                for(int j=0;j<b.length;j++){
                    b[j] = Integer.parseInt(numList[j]);
                }
                arrayList.add(b);
                break;
            }

            if(a[i]==a[i+1]-1){
                s+=(a[i]+",");
            } else{
                s+=a[i];
                String[] numList = s.split(",");
                int[] b = new int[numList.length];
                for(int j=0;j<b.length;j++){
                    b[j] = Integer.parseInt(numList[j]);
                }
                arrayList.add(b);
                s="";
            }
        }
        return arrayList;
    }


}
