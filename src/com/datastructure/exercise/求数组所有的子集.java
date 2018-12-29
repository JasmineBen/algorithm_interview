package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
public class 求数组所有的子集 {

	public static void main(String[] args) {
		int nums[] = {1,3,2,3};
		List<List<Integer>> result = new 求数组所有的子集().subsets(nums);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums != null && nums.length > 0) {
			sort(nums);//先排序
			List<Integer> subset = new ArrayList<>();
			subset(result,subset,nums,0);
		}
		return result;
	}
	
	private void subset(List<List<Integer>> result, List<Integer> subset, int[] nums,int beg) {
		System.out.println(subset);
		List<Integer> temp = new ArrayList<>(subset);
		result.add(temp);
		for(int i = beg;i<nums.length;i++) {
			//跳过相同的元素
			while(i+1<nums.length && nums[i] == nums[i+1]) {
				i++;
			}
			subset.add(nums[i]);
			subset(result,subset,nums,i+1);
			//这一步很重要,保证
			subset.remove(subset.size()-1);
		}
	}
	
	private void sort(int[] nums) {
		for(int i = 0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
}
