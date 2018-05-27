package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε�����
 *
 */
public class FindNumsAppearOnce {
	
	/*
	 * ������λ����ʵ�֣�����������������������
	 * �����Ľ���϶���������ֻ����һ�ε��������Ľ��
	 */
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array != null && array.length > 2){
			int temp = 0;
			//��������Ϊaabbccddef,a^a^b^b^c^c^d^d^e^f = 0^e^f
			for(int i : array){
				temp ^= i;//0^0^e^f = 0^e^f = e^f
			}
			int indexOfOne = findFirstBitOne(temp);
			//����indexOfOneλ��Ϊ1��������һ�飬Ϊ0�ĵڶ��飬�����Ͱ�e��f��Ϊ������
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
	
	//�ж�n�ĵ�indexλ�Ƿ�Ϊ1
	private boolean judgeIndexIsOne(int index,int n){
		return ((n >> index)&1) == 1;
	}

	//e��f��ȣ���e^f�϶���һλ�Ķ�������1���ҵ���
	public int findFirstBitOne(int num) {
		int indexBit = 0;//num���32λ��int��������java�ڴ���ռ32λ
		while (((num & 1) == 0) && (indexBit) < 32) {
			num = num >> 1;
			++indexBit;
		}
		return indexBit;
	}
}
