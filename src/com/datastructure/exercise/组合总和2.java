package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：所有数字（包括目标数）都是正整数。解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	示例 2:
	输入: candidates = [2,5,2,1,2], target = 5,
	所求解集为:
	[
	  [1,2,2],
	  [5]
	]
 *
 */
public class 组合总和2 {
	
	public static void main(String[] args) {
		int[] candidates = {1,1,1,3,3,5};
		List<List<Integer>> result = new 组合总和2().combinationSum(candidates, 8);
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
