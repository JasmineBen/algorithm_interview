package com.datastructure.exercise;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 *
 */
public class 第一个只出现一次的字符 {

	public static void main(String[] args) {
		String s = "google";
		System.out.println(firstAppearingOnce(s));
	}
	// 如果当前字符流没有存在出现一次的字符，返回#字符。
	public static char firstAppearingOnce(String s) {
		char[] chars = s.toCharArray();
		// char占8位，可以用一个256的数组表示
		int[] input = new int[256];
		for(char c : chars){
			if(input[c] == 0){
				input[c] = 1;
			}else{
				input[c] += 1;
			}
		}
		for (char c : chars) {
			if (input[c] == 1) {
				return c;
			}
		}
		return '#';
	}
}
