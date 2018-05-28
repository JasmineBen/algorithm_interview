package com.datastructure.exercise;

/**
 * շ���������Լ��
 * @author zhoupeiyuan
 *
 */
public class Gcd {
	
	public static void main(String[] args) {
		System.out.println(gcd(3,1));
		System.out.println(gcd(16,12));
	}

	/**
	 * ��num1>num2,��num1����num2��������Ϊres,
	 * ���res=0,˵��num1��������num2��num2�������Լ����
	 * ���res!=0,����num1=num2,num2=res���������Ϲ���
	 * ֤����
	 * num1>num2,����num1=a*num2+b,b����num1����num2��������
	 * ����gcd(num1,num2)=m, gcd(num2,b)=n;
	 * ����m��num1��num2�����Լ��������m���Ա�num1��num2����������m���Ա�a*num2������m�Ϳ��Ա�num1-a*num2������
	 * ����m���Ա�b����������m��num1/num2�����Լ����m��num2��b�Ĺ�Լ��������һ�������������m<=n.
	 * 
	 * n��num2��b�����Լ��������m�ܱ�a*num2������Ҳ�ܱ�a*num2+b�����������ܱ�num1������
	 * ����nҲ��num1��num2�Ĺ�Լ��������һ�������ġ���n<=m
	 * 
	 * ��m<=n n<=m��֪m=n��m,n����num1,num2�����Լ������gcd(num1,num2)=gcd(num2,b)
	 * 
��	 */
	public static int gcd(int num1,int num2){
		if(num1 < num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num1 % num2 == 0){//����������num2�������Լ��
			return num2;
		}
		return gcd(num2,num1%num2);
	}
}
