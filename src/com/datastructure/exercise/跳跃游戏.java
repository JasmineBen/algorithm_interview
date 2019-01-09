package com.datastructure.exercise;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是跳跃到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class 跳跃游戏 {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new 跳跃游戏().canJump(nums));
	}
	/**
	 * 动态规划
	 * dp[i]表示到达i位置剩余的步数，dp[0]=0,则有：
	 * dp[i] = max(dp[i-1],nums[i-1]) - 1;
	 * 例如{2,3,1,1,4}，dp[0]=0,dp[1]=1,表示nums[0]跳到nums[1]剩余1步，nums[0]=2,而跳到nums[1]需要1步，则剩余2-1=1步
	 * 同理，nums[1]跳到nums[2]剩余2步，dp[2]=2,nums[1]=3,max(nums[1],dp[1])-1=2。
	 * 如果dp[i] < 0说明剩余步数不够了，跳不到终点了
	 */
	public boolean canJump(int[] nums) {
		if (nums != null && nums.length > 0) {
			int[] dp = new int[nums.length];
			dp[0] = 0;
			for (int i = 1; i < nums.length; i++) {
				dp[i] = Math.max(dp[i-1], nums[i-1])-1;
				if(dp[i] < 0) {
					//无法到达当前位置
					return false;
				}
			}
		}
		return true;
	}
}
