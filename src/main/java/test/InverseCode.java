package test;

/**
 * 输入整数，输出整数的反码
 */
public class InverseCode {
    public static void main(String args[]){
        System.out.println(demo(7));
    }

    public static int demo(int num){
        if(num==1)
            return 0;
        if(num==0)
            return 1;

        int i = num%2;
        return demo((num-i)/2)*2+(i+1)%2;
    }
}
