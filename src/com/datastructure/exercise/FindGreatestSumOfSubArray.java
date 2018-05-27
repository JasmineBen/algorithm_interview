package com.datastructure.exercise;

/**
 * 计算连续子向量的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
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
			//负数加上任何数只会使这个数更小，所以如果tmpSum是负数，子向量就从a[i]开始
			tmpSum = tmpSum < 0 ? array[i] :  tmpSum + array[i];
			sum = tmpSum > sum ? tmpSum : sum;
		}
		return sum;
	}
}
