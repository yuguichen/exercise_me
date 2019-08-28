package LeetCode.动态规划;

public class 找零钱 {

    /**
     * 最少少数量的零钱
     * @param V
     * @param m
     * @return
     */
    public static int dp(int[]V,int m){
        int[] minSV=new int[m+1];//用于保存状态
        minSV[0]=0;
        boolean flag=true; //保证minSV[i]即d(i)只被初始化一次

        for(int i=1;i<=m;i++){
            flag=true;
            for(int j=0;j<V.length;j++){
                //d(i)=min{d(i-vj)+1}
                //先假设d(i)为要比较集合min{..}内的第一个。即将d(i)初始化为min{。。}内的第一个。
                if(V[j]<=i && flag){
                    minSV[i]=minSV[i-V[j]]+1;
                    flag=false; //保证只初始化一次
                }
                //获取集合内最小的一个赋值给d(i) 即d(i)=min{d(i-vj)+1}
                //所用选取的面值vj不能大于要凑够的面值i,且的d(i-vj)是min{..}内最小的
                if(V[j]<=i && minSV[i-V[j]]+1<minSV[i]){
                    minSV[i]=minSV[i-V[j]]+1;
                }
            }
        }

        return minSV[m];
    }

    /**
     * 最多几种换法
     */
    public static int dp2(int[] V,int n){
        int[] arr = new int[V.length];
        arr[0] = 1;

        for (int i=0; i < V.length; i++)   //i从0 ~ 3     因为每个arr[j]都要有一次是假设兑换了dimes[i]，所以我们要遍历一次
        {
            for (int j =V[i]; j <= n; j++)
                //求，arr[j]的时候，可以看出arr[j] = arr[j] + arr[j-dimes[i]]，
                //对应着上面的递归方式：arr[j]就是coinExchangeRecursion(n, m-1)，
                //arr[j-dimes[i]]就是coinExchangeRecursion(n-dimes[m-1], m)
                arr[j] += arr[j-V[i]];

        }
        return arr[n];

    }

}
