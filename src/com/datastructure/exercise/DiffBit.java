package com.datastructure.exercise;

/**
 * ���������Ķ������ж���λ��ͬ
 * ����int32����m��n�Ķ����Ʊ��ж��ٸ�λ(bit)��ͬô��
 */
public class DiffBit {

	public static void main(String[] args) {
		int a = 1999;
		int b = 2999;
		int ans = a ^ b;// a b��򣬲���ͬ��Bitλ��Ϊ1
		int diff = 0;
		while (ans != 0) {// ��ans��1�ĸ���
			ans = ans & (ans - 1);
			diff++;
		}
		System.out.println(diff);
	}
}
