package com.datastructure.exercise;

/**
 * ��ȡ��ת�������Сֵ
 * ��ת���飺���ǵݼ�����������ǰ����Ų���󲿷֡�
 * ���磺1��2��3��4��5��6����ת���������3��4��5��6��1��2
 * 0��1��1��1��1��1����ת���������1��1��1��1��0��1
 * @author zhoupeiyuan
 *
 */
public class MinInRotateArray {
	
	public static void main(String[] args) {
		int[] a = new int[]{3,4,5,6,1,2};
		System.out.println(getMin(a, 0, a.length-1));
		int[] b = new int[]{1,1,1,1,0,1};
		System.out.println(getMin(b, 0, b.length-1));
	}

	/**
	 * ��ת������Է�Ϊ�����ǵݼ�������[start,i],[i+1,end],
	 * i+1λ�õ�Ԫ�ؾ�����ת�������Сֵ��
	 * ���ö��ֲ��ҵķ�ʽ,mid=(start+end)/2
	 * ���a[mid]>=a[start],˵����С��λ��[mid,end]�У�
	 * ���a[mid]<=a[end],˵����С��λ��[start,mid]��;
	 * ��start+1=endʱ��˵���Ѿ��ҵ���С��������endλ��
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
