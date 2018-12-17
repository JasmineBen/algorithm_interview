package com.datastructure.exercise;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 */
public class 丑数 {

	/*
	 * 丑数的定义是1或者因子只有2 3 5，可推出丑数=丑数*丑数，假定丑数有序序列为： a1,a2,a3.......an
	 * 所以可以将以上序列（a1除外）可以分成3类，必定满足：
	 * 包含2的有序丑数序列：2*a1, 2*a2, 2*a3 .....
	 * 包含3的有序丑数序列：3*a1, 3*a2, 3*a3 ..... 
	 * 包含5的有序丑数序列：5*a1, 5*a2, 5*a3 .....
	 * 以上3个序列的个数总数和为n个，而且已知a1 = 1了， 将以上三个序列合并成一个有序序列即可
	 */
	public int GetUglyNumber_Solution(int index) {
		if (index < 7) {// 1,2,3,4,5,6都是丑数
			return index;
		}
		int[] re = new int[index];
		re[0] = 1;
		int num2 = 0;
		int num3 = 0;
		int num5 = 0;
		for (int i = 1; i < index; i++) {
			re[i] = Math.min(re[num2] * 2, Math.min(re[num3] * 3, re[num5] * 5));
			if (re[i] == re[num2] * 2) {
				num2++;
			}
			if (re[i] == re[num3] * 3) {
				num3++;
			}
			if (re[i] == re[num5] * 5) {
				num5++;
			}
		}
		return re[index - 1];
	}
}
