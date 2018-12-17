package com.datastructure.exercise;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 字符串不含重复字符的最长子串 {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	/**
	 * 字符串s的长度为n,假设i<n,以s[i]结尾的子字符串的最长子串的解为f(i)
	 * 则有 f(i+1)的值如下：
	 * s[i]...s[i-f(i)]之间，从后向前遍历，如果s[j]=s[i+1]则结束遍历，f[i+1]=i-j
	 * 否则 f[i+1]=f[i]+1;
	 */
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int[] f = new int[s.length()];
		f[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			boolean flag = true;
			for (int j = i - 1; j >= i - f[i-1]; j--) {
				if (s.charAt(j) == s.charAt(i)) {
					f[i] = i - j;
					flag = false;
					break;
				}
			}
			if(flag) {
				f[i] = f[i-1] + 1;
			}
		}
		int max = f[0];
		for(int i = 1;i < f.length;i++) {
			if(max < f[i]) {
				max = f[i];
			}
		}
		return max;
	}
}
