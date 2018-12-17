package com.datastructure.exercise;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 */
public class 判断字符串是否表示数值 {
	
	public static void main(String[] args) {
		String pattern = "[\\+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?)";
		String str = "100";
		System.out.println(str.matches(pattern));
		System.out.println(str.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?"));;
	}

	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		String input = new String(str);
		String pattern = "[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?";
		return input.matches(pattern);
	}
}
