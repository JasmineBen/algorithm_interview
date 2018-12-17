package com.datastructure.exercise;

/**
 * 给定一个绳子长度为n(n>1)，剪成m(m>1)段，每段长度都是整数
 * 假设剪成了长度为k[0],k[1],...k[m-1]段，问如何剪才能使得k[0]*k[1]*..k[m-1]最大
 */
public class 剪绳子使得每一段的乘积最大 {
	
	public static void main(String[] args) {
		System.out.println(solution(8));
	}

	
	/**
	 * 定义函数f(n)为把长度为n的绳子剪成若干段之后的乘积最大值，在剪第一刀的时候有n-1种选择，
	 * 也就是剪出来的绳子可能长度为1,2,3...n-1；因此f(n)=max(f(i)*f(n-i))
	 */
	public static int solution(int n){
		if(n<2){
			return 0;
		}
		if(n==2){
			return 1;
		}
		if(n==3){
			return 2;
		}
		int[] product = new int[n+1];//剩余长度的绳子能够计算出的最大值
		product[0]=0;
		product[1]=1;
		product[2]=2;
		product[3]=3;
		for(int i=4;i<=n;i++){
			int max = 0;
			for(int j=1;j<=i/2;j++){
				if(product[j]*product[i-j]>max){
					max = product[j]*product[i-j];
				}
			}
			product[i] = max;
		}
		return product[n];
	}
}
