package com.datastructure.exercise;

/**
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007
 * �������룺
 * 1,2,3,4,5,6,7,0
 * �����
 */
public class ������������ {
	
	public static void main(String[] args) {
		������������ test = new ������������();
		int[] input = new int[]{1,2,3,4,5,6,7,0};
		System.out.println(test.InversePairs(input));
	}

	/*
	 * �鲢����ĸĽ��������ݷֳ�ǰ����������(�ݹ�ֵ�ÿ���������һ��������)��
	 * �ϲ����飬�ϲ�ʱ������ǰ�������ֵarray[i]���ں�������ֵarray[j]ʱ����ǰ��
	 * ����array[i]~array[mid]���Ǵ���array[j]�ģ�count += mid+1 - i
	 */
	public int InversePairs(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		int count = InversePairsCore(array, copy, 0, array.length - 1);// ��ֵ��������
		return count;
	}

	
	private int InversePairsCore(int[] array, int[] copy, int low, int high) {
		if (low == high) {
			return 0;
		}
		int mid = (low + high) >> 1;
		int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
		int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
		int count = 0;
		int i = mid;
		int j = high;
		int locCopy = high;
		while (i >= low && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
			}
			copy[locCopy--] = array[i--];
			// ��ֵ��������
			if (count >= 1000000007) {
				count %= 1000000007;
			} else {
				copy[locCopy--] = array[j--];
			}
		}
		for (; i >= low; i--) {
			copy[locCopy--] = array[i];
		}
		for (; j > mid; j--) {
			copy[locCopy--] = array[j];
		}
		for (int s = low; s <= high; s++) {
			array[s] = copy[s];
		}
		return (leftCount + rightCount + count) % 1000000007;
	}
}
