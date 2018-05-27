package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * 
 * 找出所有和为S的连续正数序列
 */
public class FindContinuousSequence {

	/**
	 * (am+an)*(n-m+1)/2 = sum
	 * (am+an)*(n-m+1) = 2*sum
	 * 由于是连续的所以n-m = an-am
	 * (am+an)*(an-am+1)=2*sum=k*L（K<L）
	 * an-am+1=K
	 * am+an=L
	 * 所以an=(K+L-1)/2 am = (L-K+1)/2
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(sum<2){
			return result;
		}
		int maxK = (int)Math.sqrt(sum*2);//K的平方小于2*sum,K最大为maxK
		for(int K = maxK;K>=2;K--){
			if(2 * sum % K == 0){//K*L=2*sum，必须要整除
				int L = 2 * sum / K;
				//an=(K+L-1)/2 am = (L-K+1)/2,所以K和L必须一奇一偶
				if((K % 2 == 0 && L % 2 == 1)
						||(K % 2 == 1 && L % 2 == 0)){
					ArrayList<Integer> item = new ArrayList<Integer>();
					for(int j = (L-K+1)/2;j<=(L+K-1)/2;j++){
						item.add(j);
					}
					result.add(item);
				}
			}
		}
		return result;
	}
}
