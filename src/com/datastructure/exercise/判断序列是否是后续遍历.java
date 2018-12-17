package com.datastructure.exercise;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ���� ����������Yes,�������No���������������������������ֶ�������ͬ��
 *
 */
public class �ж������Ƿ��Ǻ������� {

	public static void main(String[] args) {
		int[] a = new int[] { 1,2,3,4,5 };
		�ж������Ƿ��Ǻ������� test = new �ж������Ƿ��Ǻ�������();
		System.out.println(test.verifySquenceOfBST(a));
	}

	/**
	 * �������������ԣ���ڵ�<��<С���ҽڵ� �������Ϊ��������,����������
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean verifySquenceOfBST(int[] sequence) {
		if(sequence == null || sequence.length == 0){
			return false;
		}
		int size = sequence.length;
		int i = 0;
		while (--size > 0) {
			while (i < size && sequence[i++] < sequence[size]);
			while (i < size && sequence[i++] > sequence[size]);
			if (i < size){
				return false;
			}
			i = 0;
		}
		return true;
	}

}
