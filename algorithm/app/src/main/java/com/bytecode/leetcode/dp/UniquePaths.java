package com.bytecode.leetcode.dp;

/**
 * 62. Unique Paths
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 * <p>
 * <a href="https://leetcode.com/problems/unique-paths/">62. Unique Paths</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/unique-paths/">62. 不同路径</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class UniquePaths {

    /**
     * 1. 设dp为每格可能路径的总数, 则第一行和第一列均为1
     * 2. dp[i][j]则为dp[i - 1][j] 加上dp[i][j - 1]的总和
     * <p>
     * 1. let dp is the sum of possible unique paths, as we know dp of the first row and column is 1
     * 2. dp[i][j] is the sum of left dp and the top dp, that is dp[i - 1][j] + dp[i][j - 1]
     *
     * @param m m
     * @param n n
     * @return int
     */
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
