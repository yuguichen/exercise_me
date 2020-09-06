package LeetCode.动态规划;

public class 路径问题 {

    /**
     *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i=n-2; i>=0; i--){
            dp[m-1][i] = 1;
        }
        for(int i=m-2; i>=0; i--){
            dp[i][n-1] = 1;
        }

        for(int i= m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    /**
     *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     *      3x3 网格的正中间有一个障碍物。
     *      从左上角到右下角一共有 2 条不同的路径：
     *          1. 向右 -> 向右 -> 向下 -> 向下
     *          2. 向下 -> 向下 -> 向右 -> 向右
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        obstacleGrid[m-1][n-1] = obstacleGrid[m-1][n-1]==1?0:1;

        for(int i=n-2; i>=0; i--){
            if(obstacleGrid[m-1][i]==1)
                obstacleGrid[m-1][i] = 0;
            else
                obstacleGrid[m-1][i] = obstacleGrid[m-1][i+1];
        }
        for(int i=m-2; i>=0; i--){
            if(obstacleGrid[i][n-1]==1)
                obstacleGrid[i][n-1] = 0;
            else
                obstacleGrid[i][n-1] =  obstacleGrid[i+1][n-1];
        }

        for(int i= m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                if(obstacleGrid[i][j]==1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
            }
        }
        return obstacleGrid[0][0];
    }

    /**
     * 在二维网格 grid 上，有 4 种类型的方格：
     *      1 表示起始方格。且只有一个起始方格。
     *      2 表示结束方格，且只有一个结束方格。
     *      0 表示我们可以走过的空方格。
     *      -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
     *
     * 示例 1：
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * 输出：2
     *
     * 思路：回溯法，深度优先遍历，走过来的路设置障碍物
     */

    int endRow;
    int endCol;
    int result;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int todo=0; // 所有可通过的方格总数
        int startRow =0;
        int startCol =0;
        // 计算todo,找到起点和终点
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=-1){
                    todo++;
                    if(grid[i][j]==1){
                        startRow = i;
                        startCol = j;
                    }
                    if(grid[i][j]==2){
                        endRow = i;
                        endCol = j;
                    }
                }
            }
        }

        dfs(grid,startRow,startCol,todo);
        return result;
    }

    public void dfs(int[][] grid, int startRow, int startCol,int todo){
        todo--;
        if(todo<0)
            return ;
        if( startRow==endRow && startCol==endCol){
            if(todo == 0)
                result++;
            return;
        }

        grid[startRow][startCol] = 3;// 设置障碍物
        if(startRow-1>=0 && grid[startRow-1][startCol]%2==0)
            dfs(grid,startRow-1,startCol,todo);
        if(startCol-1>=0 && grid[startRow][startCol-1]%2==0)
            dfs(grid,startRow,startCol-1,todo);
        if(startRow+1<grid.length && grid[startRow+1][startCol]%2==0)
            dfs(grid,startRow+1,startCol,todo);
        if(startCol+1<grid[0].length && grid[startRow][startCol+1]%2==0)
            dfs(grid,startRow,startCol+1,todo);

        grid[startRow][startCol] = 0;// 清除障碍物
    }


}
