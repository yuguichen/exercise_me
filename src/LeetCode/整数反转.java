package LeetCode;

/**
 * 给出一个二进制为32位有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 */
public class 整数反转 {
    public static void main(String[] args){

    }

    public static int reverse(int x) {

        int result = 0;

        while(x!=0){
            int temp = x%10;
            x = x/10;

            if(x == 0){
                if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && temp>7))
                    return 0;
                if(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && temp<-8))
                    return 0;
            }

            result = result*10 + temp;
        }


        return result;
    }
}
