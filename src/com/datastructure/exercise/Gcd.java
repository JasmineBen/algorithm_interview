package com.datastructure.exercise;

/**
 * 辗除法求最大公约数
 * @author zhoupeiyuan
 *
 */
public class Gcd {
	
	public static void main(String[] args) {
		System.out.println(gcd(3,1));
		System.out.println(gcd(16,12));
	}

	/**
	 * 另num1>num2,将num1除以num2的余数记为res,
	 * 如果res=0,说明num1可以整除num2，num2就是最大公约数。
	 * 如果res!=0,就另num1=num2,num2=res，继续以上过程
	 * 证明：
	 * num1>num2,则有num1=a*num2+b,b就是num1除以num2的余数。
	 * 假设gcd(num1,num2)=m, gcd(num2,b)=n;
	 * 由于m是num1和num2的最大公约数，所以m可以被num1和num2整除，所以m可以被a*num2整除，m就可以被num1-a*num2整除；
	 * 所以m可以被b整除，所以m是num1/num2的最大公约数，m是num2和b的公约数，但不一定是最大，所以有m<=n.
	 * 
	 * n是num2和b的最大公约数，所以m能被a*num2整除，也能被a*num2+b整除，所以能被num1整除，
	 * 所以n也是num1和num2的公约数，但不一定是最大的。有n<=m
	 * 
	 * 由m<=n n<=m可知m=n，m,n就是num1,num2的最大公约数，且gcd(num1,num2)=gcd(num2,b)
	 * 
，	 */
	public static int gcd(int num1,int num2){
		if(num1 < num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num1 % num2 == 0){//可以整除，num2就是最大公约数
			return num2;
		}
		return gcd(num2,num1%num2);
	}
}
