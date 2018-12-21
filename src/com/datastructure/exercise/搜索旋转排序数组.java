package com.datastructure.exercise;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class 搜索旋转排序数组 {
	
	public static void main(String[] args) {
		int[] a = {1};
		System.out.println(new 搜索旋转排序数组().search(a,1));
	}

	/**
	 * 升序数组的旋转肯定是某个节点i使得nums[i...n]<num[0,i-1],其中[0,i-1]、nums[i,n]都是升序的
	 * 要求复杂度是O(log n)，肯定不能从头到尾按顺遍历。
	 * log n是树的深度，肯定需要将问题分为两个子问题，即可使用类似二分的方式查找
	 *
	 */
	public int search(int[] nums, int target) {
		if (nums != null) {
			int low = 0;
			int high = nums.length - 1;
			while (low <= high) {
				if (nums[low] == target) {
					return low;
				}
				if (nums[high] == target) {
					return high;
				}
				if (nums[low] > target && nums[high] < target) {
					return -1;
				}
				int middle = (low + high) / 2;
				if(nums[middle] == target) {
					return middle;
				}else if (nums[low] < nums[middle]) {
					// 左边的数组是递增的，右边可能是旋转也可能是递增
					if (target < nums[middle] && target >= nums[low]) {
						//左边递增这种情况只有nums[start]<=target<=nums[middle]时候才在左边查询
						high = middle - 1;
					} else {
						//否则在右边查询
						low = middle + 1;
					}
				} else {
					//左边是旋转的，右边肯定是递增的
					if (target > nums[middle] && target <= nums[high]) {
						low = middle + 1;
					} else {
						high = middle - 1;
					}
				}
			}
		}
		return -1;
	}

}
