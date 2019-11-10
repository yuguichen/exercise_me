package 笔试.拼多多;


import java.util.Scanner;

public class Main4 {
    private static final  int mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int i=0;i<t;i++){
            long n = in.nextLong();
            int m = in.nextInt();
            if(m==0){
                long result = 4L;
                while(n>1){
                    result = (result*3)%mod;
                    n--;
                }
                System.out.println(result);
            } else {
                long[] wi = new long[m];
                int[] ci = new  int[m];
                for(int j=0;j<m;j++){
                    wi[j] = in.nextLong();
                }
                for(int j=0;j<m;j++){
                    ci[j] = in.nextInt();
                }

                long result = 1L;
                if(wi[0] != 1){
                    long temp = wi[0]-1;
                    while(temp>0){
                        result = (result*3)%mod;
                        temp--;
                    }
                }

                for(int j=1;j<m;j++){
                    if(wi[j]-wi[j-1]==1 && ci[j]==ci[j-1]){
                        result = 0L;
                        break;
                    }
                    if(wi[j]-wi[j-1]==1){
                        continue;
                    }
                    if(wi[j]-wi[j-1]==2 && ci[j]==ci[j-1]){
                        result = (result *3)%mod;
                        continue;
                    }
                    if(wi[j]-wi[j-1]==2 && ci[j]!=ci[j-1]){
                        result = (result *2)%mod;
                        continue;
                    }
                    if(wi[j]-wi[j-1]>2){
                        result =  result *(long)Math.pow(3,wi[j]-wi[j-1]-3);
                        result = (result *7)%mod;
                        continue;
                    }
                }
                if(result!=0L && wi[m-1]<n){
                    long temp = n-wi[m-1];
                    while(temp>0){
                        result = (result*3)%mod;
                        temp--;
                    }
                }
                System.out.println(result);
            }
        }
    }

}
