package com.datastructure.exercise;

/**
 * 在一个int数组里查找这样的数，它大于等于左侧所有数，小于等于右侧所有数。
 * 只用一个额外数组和少量其它空间实现
 */
public class FindPartionNum {

	public static void main(String[] args) {
		int[] a = new int[]{3,2,1,4,5,9,8,10,7,6,5};
		System.out.println(find(a));
	}
	
	/**
	 * 根据原数组a建立一个辅助数组data,data[i]=max{a[0],a[1],...a[i]};
	 * 倒序遍历a，用一个临时变量min保存到目前为止的最小数，
	 * min=min{a[i],...a[len-1]}
	 * 然后找出满足a[i]>=data[i-1]&&a[i]<=min的即可
	 */
	public static int find(int[] a) {
		int len = a.length;
		int[] data = new int[len];
		int max = a[0];
		data[0] = a[0];
		for (int i = 1; i < len; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			data[i] = max;
		}
		int min = data[len-1];
		for (int i = len- 1; i >= 1; i--) {
			//min=min{a[i],...a[len-1]}
			if(a[i] < min){
				min = a[i];
			}
			//data[i-1]=max{a[0],...a[i-1]}
			//a[i]>=max{a[0],...a[i-1]}
			//a[i]<=min{a[i]...a[len-1]}
			if(a[i]>=data[i-1] && a[i]<=min){
				return data[i];
			}
		}
		return -1;
	}
}
