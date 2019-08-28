package 笔试.京东;

import java.util.Scanner;
// 69079936
// 236011312
// 77957850
// 653604087
// 443890802
// 277126428
// 755625552
// 768751840
// 993860213
// 882053548
/**
 * 合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。
 * 现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，
 * 使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），
 * 那么最多能将这些学生分成多少组？
 */

public class Main1 {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        if(N == 1)
//            System.out.println(1);

        long[] high = {2,1,3,2,4,3};
        int N = high.length;
//        for(int i=0;i<N;i++){
//            high[i] = in.nextInt();
//        }
        int result = 1;
        long start = high[0];
        long max = high[0];

        for(int i=1;i<N;i++){
            if(high[i]<=high[i-1] ){
               continue;
            } else {
                result++;

            }
        }
        System.out.println(result);
    }

}
