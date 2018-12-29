package com.datastructure.exercise;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class 寻找两个有序数组的中位数 {
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {1};
		System.out.println(findMedianSortedArrays(A,B));
	}

	/**
	 * 中位数，又称中点数，中值。中数是按顺序排列的一组数据中居于中间位置的数，即在这组数据中，有一半的数据比他大，有一半的数据比他小
	 * 如果数组长度是奇数，中位数=A[n/2]
	 * 如果数组长度为偶数，中位数=(A[(n-1)/2]+A[n/2])/2
	 * 最暴力的解法是先归并，然后取中位数，但是时间复杂度为O(m+n)，不满足要求。
	 * 
	 * 假设两个数组分别为A B:
	 * 将A分为A[0]、A[1]...A[i-1]、A[i]、A[i+1]...A[m-1]
	 * 将B分为B[0]、B[1]...B[j-1]、B[j]、B[j+1]...B[n-1]
	 *       left_part                 right_part
	 * A[0]、A[1]...A[i-1]        A[i]、A[i+1]...A[m-1]
	 * B[0]、B[1]...B[j-1]        B[j]、B[j+1]...B[n-1]
	 * 求AB的中位数即转化为求：len(left_part) = len(right_part),且max(left_part)<=min(right_part);
	 * 因此要寻找i j，使得i+j=m-i+n-j(m+n是偶数，返回(max(left_part)+min(right_part))/2.0)
	 * 或者i+j=m-i+n-j+1(m+n是奇数,返回max(left_part))；
	 * 如果n>=m,只需要设置i=0~m,j=(m+n+1)/2-i,
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
			//二分法遍历数量较小的数组
			i = (low + high)/2;
			//m+n为偶数，len(left_part)=len(right_part)
			//m+n为奇数，len(left_part)=len(right_part)+1
			j = (m+n+1)/2-i;
			if(i > 0 && j < n && arrA[i-1] > arrB[j]) {
				//i应该减小
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
			//奇数个元素
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
