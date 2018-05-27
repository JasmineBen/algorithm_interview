package com.datastructure.exercise;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class OneToNSum {
	
	public static void main(String[] args) {
		System.out.println(Sum_Solution(5));
	}

	 public static int Sum_Solution(int n) {
	        int sum = n;
	        System.out.println((sum>0) && ((sum += Sum_Solution(n-1))>0));
	        return sum;
	    }
	 
	 public int Sum_SolutionA(int n) {
		 
	        return ((int)(Math.pow(n, 2)+n))>>1;
	    }
}
