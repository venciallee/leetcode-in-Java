package com.bytecode.leetcode.tree;

/**
 * 96. Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * <p>
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">96. Unique Binary Search Trees</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 * <p>
 * Created by vencial on 2019-09-09.
 */
public class UniqueBinarySearchTrees {

    /**
     * 动态规划, 详解看https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
     *
     * dp solution. see mode detail https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
     *
     * @param n n
     * @return int
     */
    public int numTrees(int n) {
        int G[] = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++ ) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
