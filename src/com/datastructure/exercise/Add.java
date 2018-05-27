package com.datastructure.exercise;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 */
public class Add {
	
	public static void main(String[] args) {
		System.out.println(Add(-5, -6));
	}
	
	public static int Add(int num1, int num2) {
		while (num2 != 0) {
			int bit = num1 ^ num2;//
			num2 = ((num1 & num2) << 1);
			num1 = bit;
		}
		return num1;
	}
}
