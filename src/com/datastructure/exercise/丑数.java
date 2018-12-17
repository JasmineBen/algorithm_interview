package com.datastructure.exercise;

/**
 * ��ֻ��������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ����������7�� 
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *
 */
public class ���� {

	/*
	 * �����Ķ�����1��������ֻ��2 3 5�����Ƴ�����=����*�������ٶ�������������Ϊ�� a1,a2,a3.......an
	 * ���Կ��Խ��������У�a1���⣩���Էֳ�3�࣬�ض����㣺
	 * ����2������������У�2*a1, 2*a2, 2*a3 .....
	 * ����3������������У�3*a1, 3*a2, 3*a3 ..... 
	 * ����5������������У�5*a1, 5*a2, 5*a3 .....
	 * ����3�����еĸ���������Ϊn����������֪a1 = 1�ˣ� �������������кϲ���һ���������м���
	 */
	public int GetUglyNumber_Solution(int index) {
		if (index < 7) {// 1,2,3,4,5,6���ǳ���
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
