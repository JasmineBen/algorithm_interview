package com.datastructure.exercise;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class 最长连续序列 {
	
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new 最长连续序列().longestConsecutive(nums));
	}

	/**
	 * 1、将所有的数加入HashSet，此时HaseSet存储了了所有不同的数字
	 * 2、遍历数组num[i]，pre=num[i]-1,next=num[i]+1,循环查询pre--和next--，直到查询失败，
	 * 的结果为next-pre-1
	 * 3、在每一次遍历结束，包含num[i]的左右相邻的数字全部被删掉了，接下来遍历其余还存在在HashSet中的元素，方法相同，
	 * 最终结果为next-pre-1中的最大值
	 */
	public int longestConsecutive(int[] nums) {
		int res = 0;
		if(nums != null && nums.length > 0) {
			HashSet<Integer> set = new HashSet<>();
			for(int i : nums) {
				set.add(i);
			}
			for(int i : nums) {
				if(set.remove(i)) {
					int pre = i-1;
					int next = i+1;
					while(set.remove(pre)) {
						pre--;
					}
					while(set.remove(next)) {
						next ++;
					}
					res = Math.max(next-pre-1, res);
				}
			}
		}
        return res;
    }
}
