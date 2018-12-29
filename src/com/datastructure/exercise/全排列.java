package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 *
 */
public class 全排列 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> result = new 全排列().permute(nums);
		for(List<Integer> item : result) {
			System.out.println(item);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums != null) {
			permute(result,nums,0);
		}
		return result;
	}
	
	/**
	 * permute(123,0)
	 *   permute(123,1)
	 *     permute(123,2)
	 *       permute(123,3) 输出123
     *     permute(132,2) 
	 *       permute(132,3) 输出232
	 *   permute(213,1)
     *     permute(213,2)
	 *       permute(213,3) 输出213
	 *     permute(231,2)
	 *       permute(231,3) 输出231
     *   permute(321,1)
     *     permute(321,2)
	 *       permute(321,3) 输出321
	 *     permute(312,2)
	 *       permute(312,3)  输出312
	 */
	public void permute(List<List<Integer>> result,int[] nums,int index) {
		if(index >= nums.length) {
			List<Integer> item = new ArrayList<>();
			for(int i : nums) {
				item.add(i);
			}
			result.add(item);
		}
		for(int i = index;i<nums.length;i++) {
			swap(i,index,nums);
			permute(result, nums, index+1);
			swap(i,index,nums);
		}
	}
	
	private void swap(int i,int j,int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
