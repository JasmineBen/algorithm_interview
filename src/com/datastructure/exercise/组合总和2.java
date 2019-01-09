package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * ˵�����������֣�����Ŀ�������������������⼯���ܰ����ظ�����ϡ� 
 * ʾ�� 1:
 * ����: candidates = [10,1,2,7,6,1,5], target = 8,
 * ����⼯Ϊ:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	ʾ�� 2:
	����: candidates = [2,5,2,1,2], target = 5,
	����⼯Ϊ:
	[
	  [1,2,2],
	  [5]
	]
 *
 */
public class ����ܺ�2 {
	
	public static void main(String[] args) {
		int[] candidates = {1,1,1,3,3,5};
		List<List<Integer>> result = new ����ܺ�2().combinationSum(candidates, 8);
		for(List<Integer> item : result) {
			System.out.println(item);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(candidates != null) {
			sort(candidates);
			combinationSum(result, new ArrayList<>(),candidates,target,0);
		}
		return result;
	}
	
	private void combinationSum(List<List<Integer>> result, List<Integer> item, int[] candidates, int target,
			int index) {
		if (target == 0) {
			result.add(item);
		} else {
			for (int i = index; i < candidates.length; i++) {
				if(i > index && candidates[i] == candidates[i-1]) {
					continue;
				}
				List<Integer> temp = new ArrayList<>(item);
				temp.add(candidates[i]);
				if (target - candidates[i] >= 0) {
					combinationSum(result, temp, candidates, target - candidates[i], i+1);
				}
			}
		}
	}
	
	private void sort(int[] candidates) {
		for (int i = 0; i < candidates.length; i++) {
			for (int j = 0; j < candidates.length-i-1; j++) {
				if(candidates[j] > candidates[j+1]) {
					int temp = candidates[j];
					candidates[j] = candidates[j+1];
					candidates[j+1] = temp;
				}
			}
		}
	}
}
