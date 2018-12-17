package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 �����С�
 * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ������Ӵ���
 * ����: s1 = "ab" s2 = "eidbaooo"
 * ���: True
 * ����: s2 ���� s1 ������֮һ ("ba").
 */
public class �ַ������� {

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(new �ַ�������().checkInclusion("abc","dacbdsadsa"));
//		for(String str : result) {
//			System.out.println(str);
//		}
	}
	
	/**
	 * �ҵ�s2�г���Ϊs1���ȵ������Ӵ�������Ա�s1���Ӵ�
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
	
	//ͳ��s1 s2��ÿ���ַ����ֵ�Ƶ���Ƿ�һ����һ����˵��s1��һ�����п϶���s2һ��
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
