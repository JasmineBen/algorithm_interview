package com.datastructure.exercise;

/**
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 * ����: "babad"
 * ���: "bab"
 * ע��: "aba" Ҳ��һ����Ч�𰸡�
 *
 * ����: "cbbd"
 * ���: "bb"
 */
public class ������Ӵ� {

	private int maxLen = 0;
	private String sub = "";
	
	public static void main(String[] args) {
		������Ӵ� a = new ������Ӵ�();
		System.out.println(a.longestPalindrome("babad"));
	}
	
	/**
	 * ��������������ɢ
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		//��ÿ���㿪ʼ����������������ɢ
		for (int i = 0; i < s.length() - 1; i++) {
			//�����Ӵ�����Ϊ���������
			findLongestPalindrome(s, i, i);
			//�����Ӵ�����Ϊż�������
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
				//��������ɢ
				low--;
				high++;
			} else {
				//�˳�ѭ��
				break;
			}
		}
	}
}
