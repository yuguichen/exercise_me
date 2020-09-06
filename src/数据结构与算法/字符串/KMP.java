package 数据结构与算法.字符串;

/**
 * KMP算法： Knuth-Morris-Pratt 字符串查找算法
 */
public class KMP {

    /**
     * @param s 目标字符串
     * @param p 模式字符串
     * @param next 最大前后缀匹配表
     * @return 若匹配成功，返回匹配初始位置；若失败，返回-1；
     */
    public int kmpSearch(String s, String p,int[] next){
        int i=0;
        int j=0;
        int sLen = s.length();
        int pLen = p.length();

        while(i<sLen && j<pLen){
            // j=-1表示i之前没有字符串匹配
            if(j==-1 || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            } else{
                // 不匹配时，有匹配表查找之前可能匹配的位置
                j = next[j];
            }
        }

        if(j==pLen)
            return i-j;
        else
            return -1;
    }

    /**
     *
     * @param p 模式字符串；
     * @return
     */
    public int[] getNext(String p){
        if(p.length() == 0)
            return null;

        int pLen = p.length();
        int[] next = new int[pLen];
        next[0] = -1;

        int k=-1;
        int j=0;

        while(j<pLen){
            if(k==-1 || p.charAt(j)==p.charAt(k)){
                k++;
                j++;
                if(p.charAt(j)!=p.charAt(k))
                    next[j]=k;
                else
                    next[j]=next[k];

            } else{
                k=next[k];
            }
        }


        return next;
    }
}
