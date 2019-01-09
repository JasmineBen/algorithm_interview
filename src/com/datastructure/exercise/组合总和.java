package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * candidates �е����ֿ����������ظ���ѡȡ��
 * ˵�����������֣����� target���������������⼯���ܰ����ظ�����ϡ� 
 * ʾ�� 1:
 * ����: candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ:
	[
	  [7],
	  [2,2,3]
	]
	ʾ�� 2:
	����: candidates = [2,3,5], target = 8,
	����⼯Ϊ:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
 */
public class ����ܺ� {
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		List<List<Integer>> result = new ����ܺ�().combinationSum(candidates, 7);
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
				List<Integer> temp = new ArrayList<>(item);
				temp.add(candidates[i]);
				if (target - i >= 0) {
					combinationSum(result, temp, candidates, target - candidates[i], i);
				}
			}
		}

	}
	
	private void sort(int[] candidates) {
		for (int i = 0; i < candidates.length; i++) {
			for (int j = i; j < candidates.length-1; j++) {
				if(candidates[j] > candidates[j+1]) {
					int temp = candidates[j];
					candidates[j] = candidates[j+1];
					candidates[j+1] = temp;
				}
			}
		}
	}
}
