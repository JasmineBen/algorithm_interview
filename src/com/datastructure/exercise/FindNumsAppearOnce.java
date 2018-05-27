package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字
 *
 */
public class FindNumsAppearOnce {
	
	/*
	 * 可以用位运算实现，如果将所有所有数字相异或，
	 * 则最后的结果肯定是那两个只出现一次的数字异或的结果
	 */
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array != null && array.length > 2){
			int temp = 0;
			//假设数组为aabbccddef,a^a^b^b^c^c^d^d^e^f = 0^e^f
			for(int i : array){
				temp ^= i;//0^0^e^f = 0^e^f = e^f
			}
			int indexOfOne = findFirstBitOne(temp);
			//所有indexOfOne位置为1的数据在一组，为0的第二组，这样就把e和f分为两组了
			//
			for(int i : array){
				if(judgeIndexIsOne(indexOfOne, i)){
					num1[0] ^= i;
				}else{
					num2[0] ^= i;
				}
			}
		}
		
		
	}
	
	//判断n的第index位是否为1
	private boolean judgeIndexIsOne(int index,int n){
		return ((n >> index)&1) == 1;
	}

	//e和f相等，则e^f肯定有一位的二进制是1，找到它
	public int findFirstBitOne(int num) {
		int indexBit = 0;//num最多32位，int类型数在java内存中占32位
		while (((num & 1) == 0) && (indexBit) < 32) {
			num = num >> 1;
			++indexBit;
		}
		return indexBit;
	}
}
