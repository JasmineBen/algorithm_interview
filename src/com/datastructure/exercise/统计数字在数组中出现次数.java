package com.datastructure.exercise;

/**
 * ͳ��һ�����������������г��ֵĴ�����
 * @author admin
 *
 */
public class ͳ�������������г��ִ��� {

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
