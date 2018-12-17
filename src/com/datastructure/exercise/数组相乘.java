package com.datastructure.exercise;

/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 *
 */
public class ������� {
	
	/**
	 * B0     1  A1  A2  A3 .... A(n-3) A(n-2) A(n-1)
	 * B1     A0 1   A2  A3 .... A(n-3) A(n-2) A(n-1)
	 * B2     A0 A1  1   A3 .... A(n-3) A(n-2) A(n-1)
	 * B3     A0 A1  A2  1  .... A(n-3) A(n-2) A(n-1)
	 * .
	 * .
	 * .
	 * B(n-3) A0 A1  A2  A3 ....   1    A(n-2) A(n-1)
	 * B(n-2) A0 A1  A2  A3 .... A(n-3)  1     A(n-1)
	 * B(n-1) A0 A1  A2  A3 .... A(n-3) A(n-2) 1
	 * 
	 * �ȼ��������� B(i) = B(i-1) * A(i-1) B0 = 1
	 * �ټ���������  B(i-1) = B(i) * A(i) B(n-1) = 1
	 */
	public int[] multiply(int[] A) {
		if(A == null){
			return null;
		}
		int[] B = new int[A.length];
		//����������
		B[0] = 1;
		for(int i = 1;i<A.length;i++){
			B[i] = B[i-1] * A[i-1];
		}
		int b = 1;
		for(int i = A.length - 2;i>=0;i--){
			b *= A[i+1];
			B[i] *= b;
		}
		return B;
    }
}
