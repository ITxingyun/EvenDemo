package com.example.javalib.arithmetic;


import java.util.HashMap;


public class LengthOfLongestSubstring {

//    @Test
//    public void test_lengthOfLongestSubstring() {
//        assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
//        assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
//        assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
//        assertEquals(lengthOfLongestSubstring(""), 0);
//        assertEquals(lengthOfLongestSubstring("a"), 1);
//        assertEquals(lengthOfLongestSubstring("dvdf"), 3);
//        assertEquals(lengthOfLongestSubstring("abba"), 2);
//        assertEquals(lengthOfLongestSubstring("tmmzuxt"), 5);
//    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * <p>
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    private int lengthOfLongestSubstring(String s) {
        //tmmzuxt
        int index = 0;
        int longestStr = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                if (index < map.get(c) + 1) {
                    index = map.get(c) + 1;
                }
            }
            map.put(c, i);
            int tempL = i - index + 1;
            if (longestStr < tempL) {
                longestStr = tempL;
            }
        }
        return longestStr;
    }
}
