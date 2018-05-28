package com.datastructure.exercise;

/**
 * ��һ��int������������������������ڵ��������������С�ڵ����Ҳ���������
 * ֻ��һ��������������������ռ�ʵ��
 */
public class FindPartionNum {

	public static void main(String[] args) {
		int[] a = new int[]{3,2,1,4,5,9,8,10,7,6,5};
		System.out.println(find(a));
	}
	
	/**
	 * ����ԭ����a����һ����������data,data[i]=max{a[0],a[1],...a[i]};
	 * �������a����һ����ʱ����min���浽ĿǰΪֹ����С����
	 * min=min{a[i],...a[len-1]}
	 * Ȼ���ҳ�����a[i]>=data[i-1]&&a[i]<=min�ļ���
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
			if(a[i] < min){
				min = a[i];
			}
			//a[i]>=data[i-1],��ζ��a[i]��������ߵ�����Ԫ��
			//a[i]<=min˵��a[i]С���ұߵ���Сֵ��Ҳ��С���ұߵ�����Ԫ��
			if(a[i]>=data[i-1] && a[i]<=min){
				return data[i];
			}
		}
		return -1;
	}
}
