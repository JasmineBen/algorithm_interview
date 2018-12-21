package com.datastructure.exercise;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 输入: [1,3,5,4,7]
 *输出: 3
 *解释: 最长连续递增序列是 [1,3,5], 长度为3。
 *尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
 */
public class 最长连续递增子序列 {

	
	/**
	 * 假设以nums[i]结尾的子数组的最长递增子序列为dp[i],则有
	 * dp[i+1]=dp[i]+1  (nums[i+1]>nums[i])
	 * dp[i+1]=1 (nums[i+1]<=nums[i])
	 */
	 public int findLengthOfLCIS(int[] nums) {
		 if(nums != null && nums.length > 0) {
			 int[] dp = new int[nums.length];
			 dp[0] = 1;
			 for(int i = 1;i < nums.length;i++) {
				 if(nums[i] > nums[i-1]) {
					 dp[i] = dp[i-1]+1;
				 }else {
					 dp[i] = 1;
				 }
			 }
			 int max = dp[0];
			 for(int i = 1;i<dp.length;i++) {
				 if(max < dp[i]) {
					 max = dp[i];
				 }
			 }
			 return max;
		 }
		 return 0;
	 }
}
