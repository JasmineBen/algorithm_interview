package com.datastructure.exercise;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class 最长回文子串 {

	private int maxLen = 0;
	private String sub = "";
	
	public static void main(String[] args) {
		最长回文子串 a = new 最长回文子串();
		System.out.println(a.longestPalindrome("babad"));
	}
	
	/**
	 * 从中心向两边扩散
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		//从每个点开始，从中心向两边扩散
		for (int i = 0; i < s.length() - 1; i++) {
			//回文子串长度为奇数的情况
			findLongestPalindrome(s, i, i);
			//回文子串长度为偶数的情况
			findLongestPalindrome(s, i, i+1);
		}
		return sub;
	}

	private void findLongestPalindrome(String s, int low, int high) {
		while (low >= 0 && high < s.length()) {
			if (s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLen) {
					maxLen = high - low + 1;
					sub = s.substring(low, high + 1);
				}
				//向两边扩散
				low--;
				high++;
			} else {
				//退出循环
				break;
			}
		}
	}
}
