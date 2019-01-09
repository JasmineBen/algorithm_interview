package com.datastructure.exercise;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 */
public class 数字的补数 {

	public static void main(String[] args) {
		System.out.println(new 数字的补数().findComplement(5));
	}

	public int findComplement(int num) {
		int flag = 1;
		int result = 0;
		while (num > 0) {
			int opposite = (num % 2 + 1) % 2;
			if(opposite == 1) {
				result += flag;
			}
			num = num / 2;
			flag = flag << 1;
		}
		return result;
	}
}
