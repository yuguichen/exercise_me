package 笔试.美团;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Double[] a = new Double[n];
        String str = in.nextLine();
        str=in.nextLine();

        String[] num = str.split("\\s");
        for(int j = 0;j<n;j++){
            a[j] = Double.parseDouble(num[j]);
        }

        int result = solution(n,a);
        System.out.println(result);
    }

    public static int solution(int n, Double[] a) {
        int result = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(isTrue(a[i],a[j])){
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean isTrue(double v, double w){
        if(v==w)
            return true;
        else if(v<w && v>0.9*w)
            return true;
        else if(v>w && w>0.9*v)
            return true;
        else
            return false;

    }
}
