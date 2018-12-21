package com.datastructure.exercise;

/**
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
 * ����: [0,1,0,2,1,0,1,3,2,1,2,1]
 * ���: 6
 */
public class ����ˮ {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new ����ˮ().trap(height));
	}
	
	/**
	 * �ҵ���������maxIndex���ֱ��������maxIndex���������height[i]<root��˵���ܴ�סˮ��������Ϊroot-height[i];
	 * ���height[i]>=root��˵���治סˮ����ô������rootΪ��ֵ������������
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
