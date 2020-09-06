package LeetCode;

public class 分割数组的最大值 {

    public static void main(String[] args){
        int arr[] = {1,3,2,4,5,6};
        int result = solution(arr,2);
        System.out.println(result);
    }


    public static int solution(int[] arr, int n) {
        int lo = 0;
        int hi = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            hi += arr[i];
            if (lo < arr[i]) {
                lo = arr[i];
            }
        }

        int result = hi;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int sum = 0;
            int num = 1;
            for (int i = 0; i < length; i++) {
                if (sum + arr[i] > mid) {
                    num ++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }
            if (num <= n+1) {
                result = Math.min(result, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }
}
