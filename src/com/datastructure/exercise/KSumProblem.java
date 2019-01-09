package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;


/**
 * ����һ��N������, Ȼ�����һ������target �� ����һ���������ҵ�K�����֣�ʹ����K�����ֵĺ͵���target��
 */
public class KSumProblem {

	public static void main(String[] args) {
		int[] a = new int[] { 4, 5, 6, 8, 7, 9, 0, 1, 2, 3 };
		KSumProblem test = new KSumProblem();
		List<Pair> result = test.twoSum(a, 10);
		if (result != null) {
			for (Pair pair : result) {
				System.out.print(pair);
				System.out.println();
			}
		}

	}

	/**
	 * 2-sum,������Ȼ������ͷβָ���ҵ�������ʹ�����ǵĺ͵���target
	 * 
	 */
	private List<Pair> twoSum(int[] a, int target) {
		����.quickSort(a);
		return computeTwoSum(a, target,-1);
	}
	
	private  List<Pair> computeTwoSum(int[] a, int target,int currentIndex) {
		List<Pair> result = new ArrayList<>();
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			if(start == currentIndex){
				start ++;
			}
			if(end == currentIndex){
				end --;
			}
			if(start >= end){
				break;
			}
			int sum = a[start] + a[end];
			if (sum == target) {
				result.add(new Pair(a[start], a[end]));
				start++;
				end--;
			}else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return result;
	}

	/**
	 * 1������
	 * 2����������õ�����a,�鿴�Ƿ���� target-a[i]��twoSum
	 */
	private List<Pair> threeSum(int[] a, int target) {
		����.quickSort(a);
		return computeThreeSum(a, target,-1);
	}
	
	
	private List<Pair> computeThreeSum(int[] a, int target, int currentIndex) {
		List<Pair> threePair = new ArrayList<>();
		for (int index = 0; index < a.length; index++) {
			if (currentIndex != index) {
				List<Pair> result = computeTwoSum(a, target - a[index], index);
				if (result != null) {
					for (Pair p : result) {
						if (!p.datas.contains(a[index])) {
							p.datas.add(a[index]);
							if (!threePair.contains(p)) {
								threePair.add(p);
							}
						}
					}
				}
			}
		}
		return threePair;
	}
	
	/**
	 * 1������
	 * 2������ÿ��a[i]����target-a[i]��threesum
	 */
	private List<Pair> fourSum(int[] a, int target) {
		����.quickSort(a);
		List<Pair> fourPair = new ArrayList<>();
		for (int index = 0;index<a.length;index++) {
			List<Pair> result = computeThreeSum(a, target - a[index],index);
			if (result != null) {
				for (Pair p : result) {
					if (!p.datas.contains(a[index])) {
						p.datas.add(a[index]);
						if (!fourPair.contains(p)) {
							fourPair.add(p);
						}
					}
				}

			}
		}
		return fourPair;
	}
	

	private class Pair {
		List<Integer> datas = new ArrayList<>();

		Pair(int... data) {
			for (int i : data) {
				datas.add(i);
			}
		}

		@Override
		public String toString() {
			String s = "";
			for (int i : datas) {
				s += i + ",";
			}
			return s;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Pair)){
				return false;
			}
			Pair pair = (Pair)obj;
			if(pair.datas.size() == 0 || pair.datas.size() != this.datas.size()){
				return false;
			}
			for(int i : pair.datas){
				if(!this.datas.contains(i)){
					return false;
				}
			}
			return true;
		}
	}

}
