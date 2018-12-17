package com.datastructure.exercise;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε�����
 *
 */
public class ������ֻ����һ�ε��� {
	
	public static void main(String[] args) {
		������ֻ����һ�ε��� test = new ������ֻ����һ�ε���();
		int[] a = {11,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,10};
		test.FindNumsAppearOnce(a);
	}
	
	/*
	 * ������㽻���ɺͽ����a^b^c=a^c^b=a^(b^c)
	 * 0����κ���a�Ľ������a
	 * ������λ����ʵ�֣�����������������������
	 * �����Ľ���϶���������ֻ����һ�ε��������Ľ��
	 */
	public void FindNumsAppearOnce(int[] array) {
		if(array != null && array.length > 2){
			int e = 0;
			int f = 0;
			int temp = 0;
			//��������Ϊaabbccddef,a^a^b^b^c^c^d^d^e^f = 0^e^f
			for(int i : array){
				temp ^= i;//0^0^e^f = 0^e^f = e^f
			}
			//�ҵ����ұߵ�1��index��index��0��ʼ
			int indexOfOne = findFirstBitOne(temp);
			//temp�ĵ�indexOfOne��λΪ1��e f��indexOfOne�϶���ͬ������e��indexOfOneΪ1��f��indexOfOneΪ0
			//����indexOfOneλ��Ϊ1��������һ�飬Ϊ0�ĵڶ��飬�����Ͱ�e��f��Ϊ������
			for(int i : array){
				if(judgeIndexIsOne(indexOfOne, i)){//indexOfOneΪ1��
					e ^= i;
				}else{//indexOfOneΪ0
					f ^= i;
				}
			}
			System.out.println("e:"+e+";f:"+f);
		}
		
		
	}
	
	//�ж�n�ĵ�indexλ�Ƿ�Ϊ1
	private boolean judgeIndexIsOne(int index,int n){
		return ((n >> index)&1) == 1;
	}

	//e��f��ȣ���e^f�϶���һλ�Ķ�������1���ҵ����ұߵ�1
	public int findFirstBitOne(int num) {
		int indexBit = 0;//num���32λ��int��������java�ڴ���ռ32λ
		while (((num & 1) == 0) && (indexBit) < 32) {
			num = num >> 1;
			++indexBit;
		}
		return indexBit;
	}
}
