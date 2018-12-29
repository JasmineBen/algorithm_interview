package com.datastructure.exercise;

public class ������ת {

	public static void main(String[] args) {
		System.out.println(new ������ת().reverse(-2147483412));
	}
	
	//����Χ-2147483648 ���� 2147483647
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && pop > 7) ) {
				System.out.println("z");
				return 0;
			} else if (Integer.MIN_VALUE / 10 > result || (result == Integer.MIN_VALUE && pop < -8)) {
				System.out.println("zx");
				return 0;
			}
			result = result * 10 + pop;
		}
		return result;
	}
}
