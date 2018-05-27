package com.datastructure.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;

/**
 * �������
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
	 * �˻�����λ��ˣ�Ҳ����aibj��������뵽��C�ĵ�i+jλ��������λ���ɣ����磺A =17 = 1*10 + 7 = ��7,1�������ʮ���Ƶ��ݱ�ʾ�����ݴ��Ǵӵ�λ����λ������ͬ��B=25 = 2*10 + 5 = (5, 2);C = A * B = (7 * 5, 1 * 5 + 2 * 7, 1 * 2) = (35, 19, 2) = (5, 22, 2) = (5, 2. 4)=425��
	 * (1)ת������ת���ַ���ת��Ϊ���ֲ�������ת��
	 * (2)��λ��ˣ���������result_num[i+j]�У�
	 * (3)�����λ�����������0��
	 * (4)ת������ת����������ת��Ϊ�ַ�������ת��
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
		// �����λ
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
