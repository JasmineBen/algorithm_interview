package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * 
 * �ҳ����к�ΪS��������������
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
	 * ����������������n-m = an-am
	 * (am+an)*(an-am+1)=2*sum=k*L��K<L��
	 * an-am+1=K
	 * am+an=L
	 * ����an=(K+L-1)/2 am = (L-K+1)/2
	 * ������ı��ʽ����֪����K��L�϶�����һ����������һ����ż��
	 * K*L=2*sum>k*k,����k���Ϊ2*sum�Ŀ�������2*sum�����ܹ�����k��L
	 */
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return result;
		}
		int maxK = (int) Math.sqrt(2 * sum);
		for (int K = maxK; K >= 2; K--) {
			if (2 * sum % K == 0) {// ��������k
				int L = 2 * sum / K;// ����L,L�϶�����K
				if ((K % 2 == 0 && L % 2 == 1) || (K % 2 == 1 && L % 2 == 0)) {
					// K��Lһ������һ��ż��,�ҵ������
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
