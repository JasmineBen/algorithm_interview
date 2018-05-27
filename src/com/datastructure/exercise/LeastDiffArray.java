package com.datastructure.exercise;

/**
 * ����������a,b����С��Ϊn,����Ԫ�ص�ֵ��������������
 *��Ҫ��ͨ������a,b�е�Ԫ�أ�ʹ[����aԪ�صĺ�]��[����bԪ�صĺ�]֮��Ĳ���С��
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
	 * �����������к�֮��diff;Ȼ���a��b�зֱ�ȡһ��Ԫ�أ�
	 * ���ù�ʽ��diff-a[i]+b[j]-(a[i]-b[j]) = diff-2*(a[i]-b[j])
	 * �ľ���ֵ��diff�ľ���ֵ�Ƚϣ������diff��С���͸���diff��
	 * ͬʱ����Ԫ��a[i]/b[j].�����У���һ��flag������Ϊ�˳�ʹ�õġ�
	 * ������forѭ��֮��û�н������ˣ�flag=0�����˳�while��
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
						 * ���a[i]��b[j]������A B�ĺ�֮��Ϊ
						 * (sumA-a[i]+b[j])-(sumB-b[j]+a[i])=sumA-sumB-2(a[i]-b[j])=diff-2(a[i]-b[j])
						 * ������ֵ�ľ���ֵС��diff�ľ���ֵ��˵��������Ч
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
