package 笔试;

/**
 * 一个数组，一个出现1次，其他出现k次，如何找出出现一次的数
 *
 * 要点：k个相同的K进制数不进位相加的结果为0
 */
public class GetOneTimeNum {
    public static int getOnceNum(int[] arr, int k){
        int[] temp = new int[32];// 一个int型最多转换为32位2进制树
        for(int i=0; i<arr.length; i++){
            int[] res = convertNum2KNum(arr[i],k);
            for(int j=0; j<res.length;j++){
                temp[j] =  (temp[j]+res[j])%k;
            }
        }

        int result = convertK2Num(temp, k);
        return result;
    }

    /**
     * 将十进制转换为K进制数
     */
    public static int[] convertNum2KNum(int value, int k){
        int index = 0;
        int[] temp = new int[32];
        while(value!=0){
            temp[index++] = value%k;
            value=value/k;
        }
        return temp;
    }

    /**
     * 将 k进制数转换为十进制数
     * @return
     */
    public static int convertK2Num(int[] temp, int k){
        int result=0;
        for(int i=temp.length-1; i>=0; i--){
            result = result*k+temp[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {3,3,3,3,4,4,4,4,11,5,11,11,11,23,23,23,23};
        System.out.println(getOnceNum(arr,4));
    }
}
