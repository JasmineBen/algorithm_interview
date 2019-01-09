package com.datastructure.exercise;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *
 */
public class 最小差值1 {
	
	public static void main(String[] args) {
		int[] A = {2,7,2};
		System.out.println(new 最小差值1().smallestRangeI(A, 1));
	}

	/**
	 * 先求出原数组A的最大值max和最小值min，要求变换后的B数组的最小差值，
	 * 数组B的取值范围是min-K<=B[i]<=max+K,要求max(B)-min(B)最小值，
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
