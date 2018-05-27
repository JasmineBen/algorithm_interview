package com.datastructure.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;

/**
 * 大数相乘
 *
 */
public class BigIntegerMultiply {
	
	public static void main(String[] args) {
		String a = "9000099999999999999999999999999";
		String b = "999999999999990";
		System.out.println(multiply(a, b));
		BigInteger temp = new BigInteger(a);
		System.out.println(temp.multiply(new BigInteger(b)));
	}

	/**
	 * 乘积是逐位相乘，也就是aibj，结果加入到积C的第i+j位，最后处理进位即可，例如：A =17 = 1*10 + 7 = （7,1）最后是十进制的幂表示法，幂次是从低位到高位，以下同。B=25 = 2*10 + 5 = (5, 2);C = A * B = (7 * 5, 1 * 5 + 2 * 7, 1 * 2) = (35, 19, 2) = (5, 22, 2) = (5, 2. 4)=425。
	 * (1)转换并反转，字符串转换为数字并将字序反转；
	 * (2)逐位相乘，结果存放在result_num[i+j]中；
	 * (3)处理进位，消除多余的0；
	 * (4)转换并反转，将计算结果转换为字符串并反转。
	 */			
	public static String multiply(String a, String b) {
		ArrayList<Integer> aArray = new ArrayList<>();
		ArrayList<Integer> bArray = new ArrayList<>();
		for(int i = a.length()-1;i>=0;i--){
			aArray.add(a.charAt(i)-'0');
		}
		for(int i = b.length()-1;i>=0;i--){
			bArray.add(b.charAt(i)-'0');
		}
		int[] result = new int[a.length() + b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				result[i + j] += aArray.get(i) * bArray.get(j);
			}
		}
		// 处理进位
		for (int i = 0, c = 0; i < result.length; i++) {
			int k = result[i] + c;
			result[i] = k % 10;
			c = k / 10;
		}
		
		int firstZeroIndex = -1;
		for(int i = result.length-1;i>=0;i--){
			if(result[i] != 0){
				break;
			}else{
				firstZeroIndex = i;
			}
		}
		if(firstZeroIndex < 0){
			firstZeroIndex = result.length - 1;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = firstZeroIndex;i>=0;i--){
			sb.append(result[i]);
		}
		return sb.toString();
	}
}
