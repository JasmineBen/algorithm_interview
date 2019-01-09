package com.datastructure.exercise;

import java.util.Arrays;

/**
 * ����һ���������� A������ÿ������ A[i]�����ǿ���ѡ�� x = -K ���� x = K������ x �ӵ� A[i] �С�
 * �ڴ˹���֮�����ǵõ�һЩ���� B��
 * ���� B �����ֵ�� B ����Сֵ֮����ܴ��ڵ���С��ֵ��
 *
 *���룺A = [1,3,6], K = 3
 *�����3
 *���ͣ�B = [4,6,3]
 */
public class ��С��ֵ2 {
	
	public static void main(String[] args) {
		int[] A = {1,3,6};
		System.out.println(new ��С��ֵ2().smallestRangeII(A, 3));
	}

	 public int smallestRangeII(int[] A, int K) { 
		 if(A != null && A.length > 1) {
			 Arrays.sort(A);
			 int res = A[A.length-1] - A[0];
			 for(int i = 0;i<A.length-1;i++) {
				 int max = Math.max(A[i] + K, A[A.length - 1] - K);
		         int min = Math.min(A[i + 1] - K, A[0] + K);
		         res = Math.min(res, max - min);
			 }
			 return res;
		 }
		 return 0;
	 }
}
