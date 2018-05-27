package com.datastructure.exercise;

/**
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 *
 */
public class FirstNotRepeatingChar {

	public int FirstNotRepeatingChar(String str) {
		if (str != null && !str.isEmpty()) {
			int[] array = new int[256];
			char[] chars = str.toCharArray();
			for (char c : chars) {
				array[c]++;
			}
			for (int i = 0;i<chars.length;i++) {
				if (array[chars[i]] == 1) {
					return i;
				}
			}
		}
		return -1;
	}
}
