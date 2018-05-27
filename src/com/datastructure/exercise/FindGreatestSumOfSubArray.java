package com.datastructure.exercise;

/**
 * ��������������������
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)
 */
public class FindGreatestSumOfSubArray {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0){
			return 0;
		}
		int sum = array[0];
		int tmpSum = array[0];
		for(int i = 1;i<array.length;i++){
			//���������κ���ֻ��ʹ�������С���������tmpSum�Ǹ������������ʹ�a[i]��ʼ
			tmpSum = tmpSum < 0 ? array[i] :  tmpSum + array[i];
			sum = tmpSum > sum ? tmpSum : sum;
		}
		return sum;
	}
}
