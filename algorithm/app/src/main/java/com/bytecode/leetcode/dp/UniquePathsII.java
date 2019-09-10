package com.bytecode.leetcode.dp;

/**
 * 63. Unique Paths II
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * <p>
 * <a href="https://leetcode.com/problems/unique-paths-ii/">63. Unique Paths II</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/unique-paths-ii/">63. 不同路径 II</a>
 * Created by vencial on 2019-09-10.
 */
public class UniquePathsII {

    /**
     * 1. 设dp为每格可能路径的总数, 如果无路障则第一行和第一列均为1, 否则为0
     * 2. 如果obstacleGrid[i][j]是路障, 则dp[i][j]为0, 否则dp[i][j]则为dp[i - 1][j] 加上dp[i][j - 1]的总和
     * <p>
     * 1. let dp is the sum of possible unique paths, as we know dp of the first row and column is 1 if there is no obstacles
     * 2. if obstacleGrid[i][j] is obstacles, dp[i][j] should be 0, else dp[i][j] is the sum of left dp and the top dp, that is dp[i - 1][j] + dp[i][j - 1]
     *
     * @param obstacleGrid obstacleGrid
     * @return int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int dp[][] = new int[row][column];
        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < column; i++) {
            if (obstacleGrid[0][i] != 1 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][column - 1];
    }
}
