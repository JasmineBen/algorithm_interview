package com.datastructure.exercise;

/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。 
 *
 */
public class 重构数组使得奇数在左偶数在又 {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9};
		重构数组使得奇数在左偶数在又 test = new 重构数组使得奇数在左偶数在又();
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
				while (i < array.length && array[i] % 2 != 0) {// 找到第一个偶数
					i++;
				}
				j = i + 1;
				while (j < array.length && array[j] % 2 == 0) {// 找到第一个奇数
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
	
	//是否是偶数
	private boolean isEven(int n){
	    if(n%2==0)
	        return true;
	    return false;
	}
}
