package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 翻转字符串中的单词 {
	
	public static void main(String[] args) {
		reverseWords("a b a");
	}

	/**
	 * 1、去除首尾的空格
	 * 2、循遍历字符串：找到第一个空格，并将空格之前的单词存到数组，同时设置flag
	 * 3、继续 遍历，当遇到非空字符时设置下一次subString的位置nextStart，并设置flag
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		if(s.trim().length() == 0) {
			return "";
		}
		s = s.trim();//去掉前面和后面的字符串
		List<String> list = new ArrayList<>();
		boolean flag = false;
		int nextStart = 0;
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == ' ') {
				if(flag) {
					list.add(s.substring(nextStart, i));
					flag = false;
				}
			}else {
				if(!flag) {
					nextStart = i;
					flag = true;
				}
			}
		}
		list.add(s.substring(nextStart, s.length()));
		StringBuilder sb = new StringBuilder();
		for(int i = list.size()-1;i>=0;i--) {
			if(i == 0) {
				sb.append(list.get(i));
			}else {
				sb.append(list.get(i)).append(" ");
			}
		}
		System.out.println(sb.toString()+";");
		return sb.toString();
	}
}
