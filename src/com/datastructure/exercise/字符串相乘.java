package com.datastructure.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;

/**
 * �������
 *
 */
public class �ַ������ {
	
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
	 * ����a�ʹ���b��˽��λ��ΪaLen+bLen�����λ�н�λ������aLen+bLen-1�����λ�޽�λ����
	 * aLen��bLen�ֱ�Ϊ��a����b�ĳ��ȣ�������˽��result[i+j]=a[i]*b[j];
	 * �˻�����λ��ˣ�Ҳ����a[i]*b[j]��������뵽��C�ĵ�i+jλ��������λ���ɣ�
	 * ���磺A =17 = 1*10 + 7 = ��7,1�������ʮ���Ƶ��ݱ�ʾ�����ݴ��Ǵӵ�λ����λ������ͬ��B=25 = 2*10 + 5 = (5, 2);
	 * C = A * B = (7 * 5, 1 * 5 + 2 * 7, 1 * 2) = (35, 19, 2) = (5, 22, 2) = (5, 2. 4)=425��
	 * (1)ת������ת���ַ���ת��Ϊ���ֲ�������ת��
	 * (2)��λ��ˣ���������result_num[i+j]�У�
	 * (3)�����λ�����������0��
	 * (4)ת������ת����������ת��Ϊ�ַ�������ת��
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
		//�Ȳ������λ��result[i+j]���Ϊ����a[i]*b[j]den�˻�֮�ͣ��ó˻����ܴ��ڸ�λ��
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				result[i + j] += aArray.get(i) * bArray.get(j);
			}
		}
		// �����λ����result[0]��ʼ��result[len-1],����λ�Ľ�λ�ӵ���λȥ
		int c = 0;//��λ
		for (int i = 0; i < result.length; i++) {
			int k = result[i] + c;//result[i]����result[i-1]��λ��ֵ
			result[i] = k % 10;//result[i]��ȥ��λ
			c = k / 10;//result[i+1]���½�λ
		}
		
		int firstZeroIndex = -1;
		for(int i = result.length-1;i>=0;i--){
			if(result[i] != 0){//�����0����Ҫ
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
