package com.datastructure.exercise;

/**
 * ����һ����������������Ĳ����������ǶԸ����Ķ����Ʊ�ʾȡ����
 *
 */
public class ���ֵĲ��� {

	public static void main(String[] args) {
		System.out.println(new ���ֵĲ���().findComplement(5));
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
