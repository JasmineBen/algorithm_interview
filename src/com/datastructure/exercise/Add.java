package com.datastructure.exercise;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 */
public class Add {
	
	public static void main(String[] args) {
		System.out.println(add(3, 1));
//		System.out.println(multiplication(3));
	}
	
	/**
	 * 将num1和num2换为二进制再计算
	 * 
	 * 首先假设只有num1 num2只有1位二进制
	 * 1、先不考虑进位
	 * 0+0=0-->0^0=0
	 * 0+1=1-->0^1=1
	 * 1+0=1-->1^0=1
	 * 1+1=0-->1^1=0
	 * 相当于异或计算
	 * 2、考虑进位，计算进位的值
	 * 0+0=0-->0&0=0
	 * 0+1=0-->0&1=0
	 * 1+0=0-->1&0=0
	 * 1+1=1-->1&1=1
	 * 进位的结果相当于与运算,由于进位相当于左移一位，
	 * 所以有如下表达式：x^y执行加法  (x&y)<<1计算进位
	 * 
	 * 假设num1(11) num2(01)有两位二进制，11+01=100，
	 * 用上面推算的公式计算如下：11^01=10 (11&01)<<1=10,因此10+10=100
	 * 但是我们不能使用加法，那么就需要让10+10再次按照上面的算法进行计算，
	 * 10^10=00 (10&10)<<1=100 -->00+100=100
	 * 而这时候00已经不需要再计算，所以就得到最后的结果100
	 * 
	 */
	public static int add(int num1, int num2) {
		while(num2 != 0){
			//进位
			int temp = num1;
			num1 = (num1 & num2)<<1;
			num2 = temp ^ num2;
		}
		return num1;
	}
	
	/**
	 * 不得使用+、-、*、/四则运算符号计算a*3
	 * a*3 = a*2+a=a<<1+a
	 */
	public static int multiplication(int a){
		return add(a<<1,a);
	}
}
