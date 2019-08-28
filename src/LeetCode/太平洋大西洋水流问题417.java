package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 m*n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
 * “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class 太平洋大西洋水流问题417 {
    @Test
    public void testFind(){
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = pacificAtlantic(matrix);
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        int m = matrix.length;
        if(m==0)
            return lists;
        int n = matrix[0].length;
        if(n==0)
            return lists;

        boolean[][] pathToTPY = new boolean[m][n];
        boolean[][] pathToDXY = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfsPath(matrix,pathToTPY,m,n,i,0);
            dfsPath(matrix,pathToDXY,m,n,i,n-1);
        }
        for(int i=0;i<n;i++){
            dfsPath(matrix,pathToTPY,m,n,0,i);
            dfsPath(matrix,pathToDXY,m,n,m-1,i);
        }

        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if(pathToTPY[i][j] && pathToDXY[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }

        return lists;
    }

    public void dfsPath(int[][] matrix, boolean[][] pathTo, int m,int n,int i, int j){
        if(pathTo[i][j])
            return;

        pathTo[i][j] = true;
        int temp = matrix[i][j];

        if(i-1>=0 && matrix[i-1][j]>=temp )
            dfsPath(matrix,pathTo,m,n,i-1,j);
        if(j-1>=0 && matrix[i][j-1]>=temp )
            dfsPath(matrix,pathTo,m,n,i,j-1);
        if(i+1<m && matrix[i+1][j]>=temp )
            dfsPath(matrix,pathTo,m,n,i+1,j);
        if(j+1<n && matrix[i][j+1]>=temp )
            dfsPath(matrix,pathTo,m,n,i,j+1);

    }


}
