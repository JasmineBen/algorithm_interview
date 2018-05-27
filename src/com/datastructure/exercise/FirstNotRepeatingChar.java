package com.datastructure.exercise;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
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
