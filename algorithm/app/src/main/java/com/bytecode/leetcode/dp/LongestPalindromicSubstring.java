package com.bytecode.leetcode.dp;

/**
 * 5. Longest Palindromic Substring
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 * <p>
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * <p>
 * Created by vencial on 2019-09-10.
 */
public class LongestPalindromicSubstring {

    /**
     * 1. 只有一个字符, 必然是回文串, 因此dp[0][0]是true
     * 2. 从左到右开始遍历字符串s, 当字符串左位l到与字符串左位r相等时, 如果r-l小于3, 去掉l位和r位字符, 剩余必然是回文串,
     * 因为字符小于1, 或者l+1到r-1位的字符串是回文串, 那么l和r相等, l到r也必然是回文串
     * <p>
     * 1. single char must be palindromic, then we know dp[0][0] should be true
     * 2. iterate string s, if S(l-r) is palindromic (r >= l),
     * then r-l should be less than 3, because without S(l) and S(r), remind char should less than 1,
     * so it should be palindromic, or S(l+1, r-1) is palindromic.
     *
     * @param s s
     * @return String
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        dp[0][0] = true;
        String palindromeStr = s.substring(0, 1);
        int palindromeLen = 1;
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l < 3 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if ((r - l + 1) > palindromeLen) {
                        palindromeStr = s.substring(l, r + 1);
                        palindromeLen = r - l + 1;
                    }
                }
            }
        }

        return palindromeStr;
    }
}
