package com.datastructure.exercise;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author admin
 *
 */
public class DuplicateNum {

	//当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，
	//会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(numbers == null || numbers.length == 0 || numbers.length != length){
	    	return false;
	    }
	    for(int i = 0;i< length;i++){
	    	if(numbers[i] >= length){
	    		if(numbers[numbers[i] - length] > length){
	    			duplication[0] = numbers[i] - length;
	    			return true;
	    		}
	    		numbers[numbers[i] - length] = numbers[numbers[i]-length] + length;
	    	}else{
	    		numbers[numbers[i]] = numbers[numbers[i]] + length;
	    	}
	    }
	    return false;
    }
}
