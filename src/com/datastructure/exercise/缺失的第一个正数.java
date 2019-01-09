package com.datastructure.exercise;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 */
public class 缺失的第一个正数 {
	
	public static void main(String[] args) {
		int[] nums = {-1,4,2,1,9,10};
		System.out.println(new 缺失的第一个正数().firstMissingPositive(nums));
	}

	//把当前数放到该放的位置即可，如1应该放到第0个位置，2应该放到第1个位置
	public int firstMissingPositive(int[] nums) {
		if(nums != null) {
			for(int i = 0;i<nums.length;) {
				if(nums[i] == i+1) {
					i++;
				}else {
					//nums[i]应该放到nums[i]-1的位置
					if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
						int temp = nums[nums[i]-1];
						nums[nums[i]-1] = nums[i];
						nums[i] = temp;
						//换过来之后需要继续判断i的位置值
					}else {
						i++;
					}
				}
			}
			for(int i = 0;i<nums.length;i++) {
				if(nums[i] != i+1) {
					return i+1;
				}
			}
			return nums.length + 1;
		}
		return 1;
	}
}
