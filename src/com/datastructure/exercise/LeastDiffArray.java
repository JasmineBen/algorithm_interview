package com.datastructure.exercise;

/**
 * 有两个序列a,b，大小都为n,序列元素的值任意整数，无序；
 *　要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b元素的和]之间的差最小。
 *
 */
public class LeastDiffArray {
	
	public static void main(String[] args) {
//		int[] a = new int[]{5,5,9,10};
//		int[] b = new int[]{4,7,7,13};
		int[] a = new int[]{1,3,5,7};
		int[] b = new int[]{2,4,6,8};
		swap(a, b);
		for(int i = 0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
		System.out.println();
		for(int i = 0;i<a.length;i++){
			System.out.print(b[i]+",");
		}
	}

	/**
	 * 先求两个序列和之差diff;然后从a和b中分别取一个元素，
	 * 利用公式：diff-a[i]+b[j]-(a[i]-b[j]) = diff-2*(a[i]-b[j])
	 * 的绝对值和diff的绝对值比较，如果比diff的小，就更新diff，
	 * 同时交换元素a[i]/b[j].过程中，有一个flag，是作为退出使用的。
	 * 当两个for循环之后都没有交换的了，flag=0，就退出while。
	 */
	public static void swap(int[] a, int[] b) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < a.length; i++) {
			sumA += a[i];
			sumB += b[i];
		}
		boolean flag = true;
		int diff = sumA - sumB;
		while (flag) {
			System.out.println("loop:"+diff);
			flag = false;
			if (diff != 0) {
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < b.length; j++) {
						/**
						 * sumA-sumB=diff
						 * 如果a[i]和b[j]交换后A B的和之差为
						 * (sumA-a[i]+b[j])-(sumB-b[j]+a[i])=sumA-sumB-2(a[i]-b[j])=diff-2(a[i]-b[j])
						 * 如果这个值的绝对值小于diff的绝对值，说明交换有效
						 */
						if (a[i] != a[j] && (Math.abs(diff-2*(a[i]-b[j]))<=Math.abs(diff))) {
							flag = true;
							diff = diff-2*(a[i]-b[j]);
							int tmp = a[i];
							a[i] = b[j];
							b[j] = tmp;
						}
					}
				}
			}
		}
	}
}
