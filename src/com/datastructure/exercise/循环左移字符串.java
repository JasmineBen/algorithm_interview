package com.datastructure.exercise;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 */
public class 循环左移字符串 {

	public String LeftRotateString(String str, int n) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		int length = str.length();
		int rotate = n % length;
		if(rotate == 0){
			return str;
		}else{
			String startStr = str.substring(0, rotate);
			return str.substring(rotate)+startStr;
		}
	}
}
