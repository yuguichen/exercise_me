package 笔试.字节跳动;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 分糖
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] vals = new int[n];
        for(int i = 0; i < n; i++){
            vals[i] = sc.nextInt();
        }
    }


    @Test
    public void test(){
        int[] a = {1,2,3,5,4,3,2,1,3,4,5,1,4,3,2,1};
        int res = tang(a);
        System.out.println(res);
    }

    public int tang(int a[]){
        int length = a.length;
        int[] b = new int[length];



        for(int i=0;i<length;i++){

        }

        for(int i=0;i<length;i++){
            if(b[i]<=0){
                int start = i-1;
                int end = i+1;
                while( start>=0 && b[start]>=b[start-1] )
                    start -- ;
                while( end<length && b[end]>=b[end-1])
                    end++;

                for(int j=start+1;j<end;j++)
                    b[j]++;
            }
        }

        int sum =0;
        for(int i=0;i<length;i++){
            sum+=b[i];
        }
        return sum;
    }


}
