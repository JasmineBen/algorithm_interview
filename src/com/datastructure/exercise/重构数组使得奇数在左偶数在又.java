package com.datastructure.exercise;

/**
 *����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 *���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣 
 *
 */
public class �ع�����ʹ����������ż������ {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9};
		�ع�����ʹ����������ż������ test = new �ع�����ʹ����������ż������();
		a = test.reOrderArray(a);
		for(int i = 0;i<a.length;i++){
			System.out.print(a[i]);
		}
	}

	
	public int[] reOrderArray(int[] array) {
		if (array != null) {
			int i = 0;
			int j = 0;
			while (i < array.length && j < array.length) {
				while (i < array.length && array[i] % 2 != 0) {// �ҵ���һ��ż��
					i++;
				}
				j = i + 1;
				while (j < array.length && array[j] % 2 == 0) {// �ҵ���һ������
					j++;
				}
				if (j < array.length) {
					int tmp = array[j];
					for (int m = j; m > i; m--) {
						array[m] = array[m - 1];
					}
					array[i] = tmp;
					i++;
				} else {
					break;
				}

			}
		}
		return array;
	}
	
	//�Ƿ���ż��
	private boolean isEven(int n){
	    if(n%2==0)
	        return true;
	    return false;
	}
}
