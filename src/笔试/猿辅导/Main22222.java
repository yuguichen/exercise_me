package 笔试.猿辅导;

import java.util.Arrays;


public class Main22222 {
    public static void main(String[] args){
            int[] num = {1,2,3,4,5,6,7};
            int result = solution1(num,num.length);
            System.out.println("     "   +result);

    }

    public static int solution1(int[] num,int length){
        if(length<=2)
            return 0;

        int result = 0;
        Arrays.sort(num);

        for(int i=0;i<length;i++){
            if(num[i] == 0)
                continue;
            if(i+2>=length)
                break;

            result+=num[i];
            num[i+1]-=num[i];
            num[i+2]-=num[i];
            num[i]=0;
        }
        return result;
    }
}
