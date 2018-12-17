package com.datastructure.exercise;

/**
 * 获取旋转数组的最小值
 * 旋转数组：将非递减排序的数组的前部分挪到后部分。
 * 例如：1，2，3，4，5，6，旋转数组可以是3，4，5，6，1，2
 * 0，1，1，1，1，1的旋转数组可以是1，1，1，1，0，1
 * @author zhoupeiyuan
 *
 */
public class 旋转数组最小值 {
	
	public static void main(String[] args) {
		int[] a = new int[]{3,4,5,6,1,2};
		System.out.println(getMin(a, 0, a.length-1));
		int[] b = new int[]{1,1,1,1,0,1};
		System.out.println(getMin(b, 0, b.length-1));
	}

	/**
	 * 旋转数组可以分为两个非递减子数组[start,i],[i+1,end],
	 * i+1位置的元素就是旋转数组的最小值。
	 * 采用二分查找的方式,mid=(start+end)/2
	 * 如果a[mid]>=a[start],说明最小数位于[mid,end]中；
	 * 如果a[mid]<=a[end],说明最小数位于[start,mid]中;
	 * 当start+1=end时，说明已经找到最小数，处于end位置
	 * 
	 * 根据题意可将数组分为[m][n]两个子数组，其中m数组的最小元素是大于等于n数组的最大元素的
	 * 1、如果a[start] < a[end],说明已经递增排好顺序了
	 * 2、如果a[start] = a[mid] = a[end],则进行顺序查找，因为计算不出中间的数属于前子数组还是后子数组
	 * 3、如果a[start] <= a[mid],说明a[mid]属于m数组，只需要在a[mid]->a[end]查找即可
	 * 4、如果a[start] > a[mid],说a[mid]属于n数组，只需要在a[start]->a[mid]查找即可
	 * 5、如果start + 1 = end,说明只剩下两个元素，直接取a[end]为最小元素，因为前面的数据>=后面的数据
	 */
	public static int getMin(int[] a, int start, int end) {
		if (start + 1 == end) {
			return a[end];
		}
		int mid = (start + end) / 2;
		if (a[start] == a[mid] && a[mid] == a[end]) {
			int result = a[start];
			for (int i = start + 1; i <= end; i++) {
				if (a[i] < result) {
					return a[i];
				} else {
					result = a[i];
				}
			}
		} else if (a[mid] >= a[start]) {
			return getMin(a, mid, end);
		} else if (a[mid] <= a[end]) {
			return getMin(a, start, mid);
		}
		return -1;
	}
}
