package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * http://blog.csdn.net/joylnwang/article/details/7064115
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation {
	
	private HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		String str = "45";
		StringPermutation test = new StringPermutation();
		ArrayList<String> result = test.Permutation(str);
		for(String s : result){
			System.out.println(s);
		}
	}

	//全排列
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() == 0) {
			return result;
		}
		char[] chars = str.toCharArray();
		Permutation(chars,0,chars.length);
		result.addAll(set);
		Collections.sort(result);
		return result;
	}
	
 
	private void Permutation(char[] str, int m, int n) {
		if (m == n) {// m == n时退出,前面n-1个数已经确定
			String s = new String(str);
			set.add(s);
		} else {
			for (int i = m; i < str.length; i++) {
				swap(str, i, m);
				Permutation(str,m + 1,n);// 求第K到length个字符的全排列
				swap(str, i, m);
			}
		}
	}
	
	private void swap(char[] str,int i,int j){
		if(i != j){
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}
	}
}
