package com.datastructure.exercise;

/**
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。 补码：负数绝对值的二进制表示，每位取反，最后再加1
 * int类型在java中使用32位二进制表示
 */
public class NumberOfOneInBinaryData {

	public static void main(String[] args) {
		NumberOfOneInBinaryData test = new NumberOfOneInBinaryData();
		// for (int i = 0; i < 10; i++) {
		System.out.println(test.numberOf1(-10));
		// }
	}

	/**
	 * 与运算，同时为1&1=1，1&0=0，0&1=0，0&0=0 每次将1左移一位，再做与运算，判断当前位是否为1
	 */
	public int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	//最优解
	public int niceNumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = ((n - 1) & n);
		}
		return count;
	}
}
