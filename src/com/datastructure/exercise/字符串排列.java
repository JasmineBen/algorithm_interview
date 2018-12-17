package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */
public class 字符串排列 {

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(new 字符串排列().checkInclusion("abc","dacbdsadsa"));
//		for(String str : result) {
//			System.out.println(str);
//		}
	}
	
	/**
	 * 找到s2中长度为s1长度的所有子串，逐个对比s1和子串
	 */
	public boolean checkInclusion(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}
		if(s1.length() == 0 || s2.length() == 0) {
			return false;
		}
		if(s1.length() > s2.length()) {
			return false;
		}
		List<String> list = new ArrayList<>();
		int minusLen = s2.length() - s1.length();
		for(int i = 0;i<=minusLen;i++) {
			list.add(s2.substring(i,i+s1.length()));
		}
		for(String s : list) {
			if(check(s1, s)) {
				return true;
			}
		}
		return false;
	}
	
	//统计s1 s2中每个字符出现的频次是否一样，一样则说明s1的一个排列肯定和s2一样
	private static boolean check(String s1,String s2) {
		int[] ss1 = new int[26];
		int[] ss2 = new int[26];
		for(int i = 0;i<s1.length();i++) {
			ss1[s1.charAt(i)-'a'] ++;
			ss2[s2.charAt(i)-'a'] ++;
		}
		for(int i = 0;i<ss1.length;i++) {
			if(ss1[i] != ss2[i]) {
				return false;
			}
		}
		return true;
	} 
}
