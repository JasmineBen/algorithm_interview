package com.datastructure.exercise;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *输入：A = [1,3,6], K = 3
 *输出：3
 *解释：B = [4,6,3]
 */
public class 最小差值2 {
	
	public static void main(String[] args) {
		int[] A = {1,3,6};
		System.out.println(new 最小差值2().smallestRangeII(A, 3));
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
