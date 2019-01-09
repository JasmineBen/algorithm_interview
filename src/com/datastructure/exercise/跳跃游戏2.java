package com.datastructure.exercise;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class 跳跃游戏2 {
	
	private int minStep = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new 跳跃游戏2().jump(nums));
	}

	/**
	 * 计算某一跳的范围，
	 * cur和pre分别来保存当前的能到达的最远位置和之前能到达的最远位置
	 */
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int result = 0;
		int cur = 0;//当前能到达的最远距离
		while (cur < nums.length - 1) {//当前能够到达数组末端，退出循环
			result++;//走一步看看能到达的范围呢
			int pre = cur;//之前能到达的最远距离
			for (int i = 0; i <= pre; i++) {
				//i+nums[i]表示i节点能到达的最大距离，i表示上一次能够到达的节点，
				//上一次能够到达的节点加上当前节点能够跳的步数，就能得到当前节点下一跳的范围,
				//cur就是这些节点能够到达范围的最大值
				cur = Math.max(cur, i + nums[i]);
			}
			if (pre == cur) {
				return -1;
			}
		}
		return result;
	}
	
	//递归解法，太他妈耗时了
	private int jump(int[] nums, int index, int step) {
		if (index >= nums.length-1) {
			return step;
		}
		for (int j = 1; j <= nums[index]; j++) {
			minStep = Math.min(jump(nums,index+j,step+1),minStep);
		}
		return Integer.MAX_VALUE;
	}
}
