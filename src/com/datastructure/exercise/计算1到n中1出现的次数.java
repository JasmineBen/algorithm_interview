package com.datastructure.exercise;

/**
 * �����1��N֮�������������1���ֵĴ���
 *
 */
public class ����1��n��1���ֵĴ��� {
	
	public static void main(String[] args) {
		����1��n��1���ֵĴ��� oneNumsFrom1ToN = new ����1��n��1���ֵĴ���();
		System.out.println(oneNumsFrom1ToN.computeNums(21345));
//		System.out.println(oneNumsFrom1ToN.computeNums(10));
//		System.out.println(oneNumsFrom1ToN.computeNums(13));
//		System.out.println(oneNumsFrom1ToN.computeNums(90));
//		System.out.println(oneNumsFrom1ToN.computeNums(99));
//		System.out.println(oneNumsFrom1ToN.computeNums(1304));
//		System.out.println(oneNumsFrom1ToN.computeNums(2304));
	}
	
	/**
	 * �ֱ�����λ��ʮλ����λ...��1������
	 */
	public int computeNums(int n) {

		int sum = 0;
		int base = 1;
		int a = n / 10;
		int b = n % 10;
		while (true) {
			if (a == 0) {
				if (b > 1) {
					sum += base;
				} else {
					sum += (n - base + 1);
				}
				return sum;
			} else {
				if (b > 1) {
					sum += (a + 1) * base;
				} else if (b == 1) {
					sum += (a * base + (n - (a * 10 + b) * base) + 1);
				} else {
					sum += (a * base);
				}
			}
			System.out.println("a:" + a + ";b:" + b);
			System.out.println("sum:" + sum + ";base:" + base);
			b = a % 10;
			a = a / 10;
			base *= 10;
		}
	}

}
