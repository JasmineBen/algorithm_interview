package com.datastructure.exercise;

/**
 * 求两个数的二进制有多少位不同
 * 两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 */
public class 两个数的二进制的不同位数 {

	/**
	 * 根据异或运算
	 * 0^0=0
	 * 1^1=0
	 * 0^1=1
	 * 可以先对两个数进行异或运算，然后计算异或结果中的1的个数
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1999;
		int b = 2999;
		int ans = a ^ b;// a b异或，不相同的Bit位变为1
		int diff = 0;
		while (ans != 0) {// 求ans中1的个数
			ans = ans & (ans - 1);
			diff++;
		}
		System.out.println(diff);
	}
}
