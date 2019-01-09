package com.datastructure.exercise;

/**
 * ����һ���������� A������ÿ������ A[i]�����ǿ���ѡ������ x ���� -K <= x <= K������ x �ӵ� A[i] �С�
 * �ڴ˹���֮�����ǵõ�һЩ���� B������ B �����ֵ�� B ����Сֵ֮����ܴ��ڵ���С��ֵ��
 * ���룺A = [1], K = 0
 * �����0
 * ���ͣ�B = [1]
 * 
 * ���룺A = [1,3,6], K = 3
 * �����0
 * ���ͣ�B = [3,3,3] �� B = [4,4,4]
 *
 */
public class ��С��ֵ1 {
	
	public static void main(String[] args) {
		int[] A = {2,7,2};
		System.out.println(new ��С��ֵ1().smallestRangeI(A, 1));
	}

	/**
	 * �����ԭ����A�����ֵmax����Сֵmin��Ҫ��任���B�������С��ֵ��
	 * ����B��ȡֵ��Χ��min-K<=B[i]<=max+K,Ҫ��max(B)-min(B)��Сֵ��
	 * 
	 */
	public int smallestRangeI(int[] A, int K) {
		if (A != null && A.length > 1) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i : A) {
				if (i > max) {
					max = i;
				}
				if (i < min) {
					min = i;
				}
			}
			return Math.max(max-min-2*K, 0);

		}
		return 0;
	}
}
