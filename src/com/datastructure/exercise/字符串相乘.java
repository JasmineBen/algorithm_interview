package com.datastructure.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;

/**
 * 大数相乘
 *
 */
public class 字符串相乘 {
	
	public static void main(String[] args) {
		String a = "9000099999999999999999999999999";
		String b = "999999999999990";
		System.out.println(multiply(a, b));
		BigInteger temp = new BigInteger(a);
		System.out.println(temp.multiply(new BigInteger(b)));
		System.out.println(multiply("3","3"));
	}

	/**
	 *   999
	 * x 999
	 * 大数a和大数b相乘结果位数为aLen+bLen（最高位有进位）或者aLen+bLen-1（最高位无进位），
	 * aLen和bLen分别为数a和数b的长度，另外相乘结果result[i+j]=a[i]*b[j];
	 * 乘积是逐位相乘，也就是a[i]*b[j]，结果加入到积C的第i+j位，最后处理进位即可，
	 * 例如：A =17 = 1*10 + 7 = （7,1）最后是十进制的幂表示法，幂次是从低位到高位，以下同。B=25 = 2*10 + 5 = (5, 2);
	 * C = A * B = (7 * 5, 1 * 5 + 2 * 7, 1 * 2) = (35, 19, 2) = (5, 22, 2) = (5, 2. 4)=425。
	 * (1)转换并反转，字符串转换为数字并将字序反转；
	 * (2)逐位相乘，结果存放在result_num[i+j]中；
	 * (3)处理进位，消除多余的0；
	 * (4)转换并反转，将计算结果转换为字符串并反转。
	 */			
	public static String multiply(String num1, String num2) {
		if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return null;
		}
		if(num1.length() == 1 && num1.charAt(0) == '0') {
			return "0";
		}
		if(num2.length() == 1 && num2.charAt(0) == '0') {
			return "0";
		}
		ArrayList<Integer> aArray = new ArrayList<>();
		ArrayList<Integer> bArray = new ArrayList<>();
		for(int i = num1.length()-1;i>=0;i--){
			aArray.add(num1.charAt(i)-'0');
		}
		for(int i = num2.length()-1;i>=0;i--){
			bArray.add(num2.charAt(i)-'0');
		}
		int[] result = new int[num1.length() + num2.length()];
		//先不处理进位，result[i+j]结果为所有a[i]*b[j]den乘积之和，该乘积可能大于个位数
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				result[i + j] += aArray.get(i) * bArray.get(j);
			}
		}
		// 处理进位，从result[0]开始到result[len-1],将低位的进位加到高位去
		int c = 0;//进位
		for (int i = 0; i < result.length; i++) {
			int k = result[i] + c;//result[i]加上result[i-1]进位的值
			result[i] = k % 10;//result[i]舍去进位
			c = k / 10;//result[i+1]的新进位
		}
		
		int firstZeroIndex = -1;
		for(int i = result.length-1;i>=0;i--){
			if(result[i] != 0){//多余的0不需要
				break;
			}else{
				firstZeroIndex = i;
			}
		}
		if(firstZeroIndex < 0){
			firstZeroIndex = result.length - 1;
		}
		StringBuffer sb = new StringBuffer();
		boolean firstUnZero = false;
		for(int i = firstZeroIndex;i>=0;i--){
			if(result[i] != 0){
				firstUnZero = true;
			}
			if(firstUnZero){
				sb.append(result[i]);
			} 
		}
		return sb.toString();
	}
}
