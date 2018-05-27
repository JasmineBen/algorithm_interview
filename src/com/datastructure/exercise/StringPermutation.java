package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * http://blog.csdn.net/joylnwang/article/details/7064115
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
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

	//ȫ����
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
		if (m == n) {// m == nʱ�˳�,ǰ��n-1�����Ѿ�ȷ��
			String s = new String(str);
			set.add(s);
		} else {
			for (int i = m; i < str.length; i++) {
				swap(str, i, m);
				Permutation(str,m + 1,n);// ���K��length���ַ���ȫ����
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
