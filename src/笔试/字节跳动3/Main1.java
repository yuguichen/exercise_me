package 笔试.字节跳动3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 魏蜀吴三国士兵转换问题：
 *      两国士兵相遇转换为另一国士兵，最后有没有可能转换为一国士兵
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int[] arr = new int[3];

            arr[0]  = in.nextInt();
            arr[1] = in.nextInt();
            arr[2] = in.nextInt();
            Arrays.sort(arr);

            if(((arr[0]+arr[1])%2 == 1 && arr[2]%2==1) || ((arr[0]+arr[1])%2 == 0 && arr[2]%2==0))
                System.out.println(true);
            else
                System.out.println(false);
        }

    }
}
