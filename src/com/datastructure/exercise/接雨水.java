package com.datastructure.exercise;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class 接雨水 {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new 接雨水().trap(height));
	}
	
	/**
	 * 找到数组的最顶端maxIndex，分别从两端向maxIndex遍历，如果height[i]<root，说明能存住水，存的面积为root-height[i];
	 * 如果height[i]>=root，说明存不住水，那么就设置root为新值，并继续遍历
	 */
	public int trap(int[] height) {
		if (height != null && height.length > 0) {
			int max = height[0];
			int maxIndex = 0;
			for (int i = 1; i < height.length; i++) {
				if (max < height[i]) {
					max = height[i];
					maxIndex = i;
				}
			}
			int area = 0;
			int root = height[0];
			for (int i = 0; i < maxIndex; i++) {
				if (root < height[i]) {
					root = height[i];
				} else {
					area += root - height[i];
				}
			}

			root = height[height.length-1];
			for (int i = height.length - 1; i > maxIndex; i--) {
				if(root < height[i]) {
					root = height[i];
				}else {
					area += root - height[i];
				}
			}
			return area;
		}
		return 0;
	}
}
