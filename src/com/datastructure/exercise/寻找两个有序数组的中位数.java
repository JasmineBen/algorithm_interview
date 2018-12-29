package com.datastructure.exercise;

/**
 * ����������СΪ m �� n ���������� nums1 �� nums2��
 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
 * ����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
 * ʾ�� 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * ����λ���� 2.0
 * ʾ�� 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * ����λ���� (2 + 3)/2 = 2.5
 */
public class Ѱ�����������������λ�� {
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {1};
		System.out.println(findMedianSortedArrays(A,B));
	}

	/**
	 * ��λ�����ֳ��е�������ֵ�������ǰ�˳�����е�һ�������о����м�λ�õ������������������У���һ������ݱ�������һ������ݱ���С
	 * ������鳤������������λ��=A[n/2]
	 * ������鳤��Ϊż������λ��=(A[(n-1)/2]+A[n/2])/2
	 * ����Ľⷨ���ȹ鲢��Ȼ��ȡ��λ��������ʱ�临�Ӷ�ΪO(m+n)��������Ҫ��
	 * 
	 * ������������ֱ�ΪA B:
	 * ��A��ΪA[0]��A[1]...A[i-1]��A[i]��A[i+1]...A[m-1]
	 * ��B��ΪB[0]��B[1]...B[j-1]��B[j]��B[j+1]...B[n-1]
	 *       left_part                 right_part
	 * A[0]��A[1]...A[i-1]        A[i]��A[i+1]...A[m-1]
	 * B[0]��B[1]...B[j-1]        B[j]��B[j+1]...B[n-1]
	 * ��AB����λ����ת��Ϊ��len(left_part) = len(right_part),��max(left_part)<=min(right_part);
	 * ���ҪѰ��i j��ʹ��i+j=m-i+n-j(m+n��ż��������(max(left_part)+min(right_part))/2.0)
	 * ����i+j=m-i+n-j+1(m+n������,����max(left_part))��
	 * ���n>=m,ֻ��Ҫ����i=0~m,j=(m+n+1)/2-i,
	 * B[j-1]<=A[i] && A[i-1]<=B[j]
	 */
	public static double findMedianSortedArrays(int[] A, int[] B) {
		if((A == null && B == null)||(A.length == 0 && B.length == 0)) {
			return 0;
		}
		int m = A == null ? 0 : A.length;
		int n = B == null ? 0 : B.length;
		
		int[] arrA = A,arrB = B;
		if(m > n) {
			arrA = B;
			arrB = A;
			m = arrA.length;
			n = arrB.length;
		}
		int low = 0;
		int high = m;
		int i = 0,j = 0;
		int num1 = 0,num2 = 0;
		while(low <= high) {
			//���ַ�����������С������
			i = (low + high)/2;
			//m+nΪż����len(left_part)=len(right_part)
			//m+nΪ������len(left_part)=len(right_part)+1
			j = (m+n+1)/2-i;
			if(i > 0 && j < n && arrA[i-1] > arrB[j]) {
				//iӦ�ü�С
				high = i - 1;
			}else if(j > 0 && i < m && arrB[j-1] > arrA[i]) {
				low = i + 1;
			}else {
				if(i == 0) {
					num1 = arrB[j-1];
				}else if(j == 0) {
					num1 = arrA[i-1];
				}else {
					num1 = Math.max(arrA[i-1], arrB[j-1]);
				}
				break;
			}
		}
		
		if((m+n)%2 == 1) {
			//������Ԫ��
			num2 = num1;
		}else if(i == m){
			num2 = arrB[j];
		}else if(j == n) {
			num2 = arrA[i];
		}else {
			num2 = Math.min(arrA[i], arrB[j]);
		}
		return (num1+num2)/2.0;
		
	}
}
