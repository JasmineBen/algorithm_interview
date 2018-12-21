package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class 第k个排列 {

	
	/**
	 *首先我们要知道当n = 3时，其排列组合共有3! = 6种，当n = 4时，其排列组合共有4! = 24种，
	 *我们就以n = 4, k = 17的情况来分析，所有排列组合情况如下：
	 *1234
	 *1243
	 *1324
	 *1342
	 *1423
	 *1432
	 *2134
	 *2143
	 *2314 
	 *2341
	 *2413
	 *2431
	 *3124
	 *3142
	 *3214
	 *3241
	 *3412	<--- k = 17
	 *3421
	 *4123
	 *4132
	 *4213
	 *4231
	 *4312
	 *4321
	 *我们可以发现，每一位上1,2,3,4分别都出现了6次，当第一位上的数字确定了，后面三位上每个数字都出现了2次，
	 *当第二位也确定了，后面的数字都只出现了1次，
	 *当第三位确定了，那么第四位上的数字也只能出现一次，
	 *那么下面我们来看k = 17这种情况的每位数字如何确定，由于k = 17是转化为数组下标为16：
	 *最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出;
	 *第二位此时从1,2,4中取一个，k = 16时，k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，所以第二数字的下标为4 / 2 = 2，即4被取出
	 *第三位此时从1,2中去一个，k' = 4时，k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，所以第三个数字的下标为 0 / 1 = 0，即1被取出
	 *第四位是从2中取一个，k'' = 0时，k''' = 0 % (1!) = 0，而剩下的每个数字出现0！= 1次，所以第四个数字的下标为0 / 1= 0，即2被取出。
	 *那么我们就可以找出规律了
	 *a1 = k / (n - 1)!
	 *k1 = k
	 *a2 = k1 / (n - 2)!
	 *k2 = k1 % (n - 2)!
	 *...
	 *an-1 = kn-2 / 1!
	 *kn-1 = kn-2 / 1!
	 *an = kn-1 / 0!
	 *kn = kn-1 % 0!
	 */
	public static String getPermutation(int n, int k) {
		if (n > 0 && k > 0) {
			int[] f = new int[n];
			f[0] = 1;
			for (int i = 1; i < n; i++) {
				f[i] = i * f[i - 1];
			}
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			if (f[n-1] * n < k) {
				return "";
			}
			k--;
			StringBuilder res = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				int index = k / f[n - i];
				res.append(list.remove(index % list.size()));
				k = k % f[n - i];
			}
			return res.toString();
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 17));
	}
}
