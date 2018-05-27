package com.datastructure.exercise;

/**
 * 
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ�� ���룺��������ֵ�Ķ����Ʊ�ʾ��ÿλȡ��������ټ�1
 * int������java��ʹ��32λ�����Ʊ�ʾ
 */
public class NumberOfOneInBinaryData {

	public static void main(String[] args) {
		NumberOfOneInBinaryData test = new NumberOfOneInBinaryData();
		// for (int i = 0; i < 10; i++) {
		System.out.println(test.numberOf1(-10));
		// }
	}

	/**
	 * �����㣬ͬʱΪ1&1=1��1&0=0��0&1=0��0&0=0 ÿ�ν�1����һλ�����������㣬�жϵ�ǰλ�Ƿ�Ϊ1
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

	//���Ž�
	public int niceNumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = ((n - 1) & n);
		}
		return count;
	}
}
