/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package com.github.siemen.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * 找一个字符串中最长不重复子串长度
 *
 */
public class LongestSubString {
    public static void main(String[] args) {
        String target = "abcdecfgh";
        LongestSubString longestSubString = new LongestSubString();
        int max = longestSubString.lengthOfLongestSubString(target);
        System.out.println("the longest substring of ----"+ target +"---- is" + max);
    }

    private int lengthOfLongestSubString(String s) {
        return loopCheck(s);
    }

    /**
     * 嵌套循环遍历所有子串检查是否有重复字符
     * 没有则与已找到最长比较取最大
     * O（n^3）
     * */
    private int loopCheck(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(allUnique(s, i, j)) {
                    ans = Math.max(ans,j - i);
                }

            }
        }
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    private int slideWindow(String s) {
        int ans = 0, n = s.length();
        return 0;
    }
}