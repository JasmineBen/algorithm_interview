package com.datastructure.exercise;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 *
 */
public class MoreThanHalfNum {
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length == 0){
			return 0;
		}
		int num = array[0];
		int count = 1;
		for(int i = 1;i<array.length;i++){
			if(array[i] != num){
				count--;
			}else{
				count ++;
			}
			if(count == 0){
				count = 1;
				num = array[i];
			}
		}
		count = 0;
		for(int i = 0;i<array.length;i++){
			if(array[i] == num){
				count++;
			}
		}
		if(count * 2 > array.length){
			return num;
		}
		return 0;
	}
}
