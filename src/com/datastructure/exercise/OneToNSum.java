package com.datastructure.exercise;

/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����
 * for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
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
