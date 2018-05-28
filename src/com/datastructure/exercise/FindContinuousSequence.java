package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * 
 * 找出所有和为S的连续正数序列
 */
public class FindContinuousSequence {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(5050);
		for(ArrayList<Integer> sub : result){
			for(Integer i : sub){
				System.out.print(i+";");
			}
			System.out.println();
		}
	}

	/**
	 * (am+an)*(n-m+1)/2 = sum
	 * (am+an)*(n-m+1) = 2*sum
	 * 由于是连续的所以n-m = an-am
	 * (am+an)*(an-am+1)=2*sum=k*L（K<L）
	 * an-am+1=K
	 * am+an=L
	 * 所以an=(K+L-1)/2 am = (L-K+1)/2
	 * 从上面的表达式可以知道，K和L肯定必须一个是奇数，一个是偶数
	 * K*L=2*sum>k*k,所以k最大为2*sum的开方。且2*sum必须能够整除k和L
	 */
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return result;
		}
		int maxK = (int) Math.sqrt(2 * sum);
		for (int K = maxK; K >= 2; K--) {
			if (2 * sum % K == 0) {// 必须整除k
				int L = 2 * sum / K;// 计算L,L肯定大于K
				if ((K % 2 == 0 && L % 2 == 1) || (K % 2 == 1 && L % 2 == 0)) {
					// K和L一个奇数一个偶数,找到结果了
					int an = (K + L - 1) / 2;
					int am = (L - K + 1) / 2;
					ArrayList<Integer> subResult = new ArrayList<>();
					for (int i = am; i <= an; i++) {
						subResult.add(i);
					}
					result.add(subResult);
				}
			}
		}
		return result;
	}
}
