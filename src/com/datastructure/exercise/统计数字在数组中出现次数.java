package com.datastructure.exercise;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author admin
 *
 */
public class 统计数字在数组中出现次数 {

	 public int getNumberOfK(int [] array , int k) {
	      if(array == null || array.length == 0){
	    	  return 0;
	      } 
	      int count = 0;
	      for(int i = 0;i<array.length;i++){
	    	  if(k == array[i]){
	    		  count++;
	    	  }
	    	  if(count > 0 && k != array[i]){
	    		  break;
	    	  }
	      }
	      return count;
	 }
	 
}
