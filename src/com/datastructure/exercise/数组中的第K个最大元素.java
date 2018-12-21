package com.datastructure.exercise;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class 数组中的第K个最大元素 {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(new 数组中的第K个最大元素().findKthLargest(nums, 2));
	}

	/**
	 * 快排的partition的变种
	 */
	public int findKthLargest(int[] nums, int k) {
		if(nums != null && nums.length > 0 && k > 0 && k <= nums.length) {
			k--;
			int start = 0;
			int end = nums.length - 1;
			while(true) {
				int partition = partition(nums, start, end);
				if(partition == k) {
					return nums[partition];
				}else if(partition < k){
					start = partition + 1;
				}else {
					end = partition - 1;
				}
			}
		}
        return 0;
    }
	
	
	private int partition(int[] a, int start, int end) {
		int key = a[start];
		while (start < end) {//扫描顺序不能错
			while(a[end] <= key && start < end){//从后往前扫描
				end -- ;
			}
			a[start] = a[end];
			
			while(a[start] >= key && start < end){//从前往后扫描
				start ++;
			}
			a[end] = a[start];			
		}
		a[end] = key;
		return end;
	}
}
