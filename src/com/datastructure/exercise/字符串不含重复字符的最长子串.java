package com.datastructure.exercise;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * ����: "abcabcbb"
 * ���: 3 
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 */
public class �ַ��������ظ��ַ�����Ӵ� {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	/**
	 * �ַ���s�ĳ���Ϊn,����i<n,��s[i]��β�����ַ�������Ӵ��Ľ�Ϊf(i)
	 * ���� f(i+1)��ֵ���£�
	 * s[i]...s[i-f(i)]֮�䣬�Ӻ���ǰ���������s[j]=s[i+1]�����������f[i+1]=i-j
	 * ���� f[i+1]=f[i]+1;
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
