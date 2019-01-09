package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
	[
	  [7],
	  [2,2,3]
	]
	示例 2:
	输入: candidates = [2,3,5], target = 8,
	所求解集为:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
 */
public class 组合总和 {
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		List<List<Integer>> result = new 组合总和().combinationSum(candidates, 7);
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
