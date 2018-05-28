package com.datastructure.exercise;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת��
 * ���������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 */
public class SearchRotateArray {

	
	public static void main(String[] args) {
		SearchRotateArray test = new SearchRotateArray();
		System.out.println(test.minNumberInRotateArray(new int[]{2,2,2,2,0,1,1,1}));
	}
	
	public int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length == 0){
	    	return 0;
	    }
	    return search(0,array.length-1,array);
    }
	
	/**
	 * ��������ɽ������Ϊ[m][n]���������飬����m�������СԪ���Ǵ��ڵ���n��������Ԫ�ص�
	 * 1�����a[start] < a[end],˵���Ѿ������ź�˳����
	 * 2�����a[start] = a[mid] = a[end],�����˳����ң���Ϊ���㲻���м��������ǰ�����黹�Ǻ�������
	 * 3�����a[start] <= a[mid],˵��a[mid]����m���飬ֻ��Ҫ��a[mid]->a[end]���Ҽ���
	 * 4�����a[start] > a[mid],˵a[mid]����n���飬ֻ��Ҫ��a[start]->a[mid]���Ҽ���
	 * 5�����start + 1 = end,˵��ֻʣ������Ԫ�أ�ֱ��ȡa[end]Ϊ��СԪ�أ���Ϊǰ�������>=���������
	 */
	private int search(int start,int end,int[] a){
		while(a[start] >= a[end]){
			int mid = (start + end)/2;
			if(a[start] == a[mid] && a[mid] == a[end]){
				int min = a[start];
				for(int i = start;i<=end;i++){
					if(a[i] < min){
						min = a[i];
					}
				}
				return min;
			}
			if(a[start] <= a[mid]){
				start = mid;
			}else{
				end = mid;
			}
			if(start + 1 == end){
				return a[end];
			}
		}
		return a[start];
		
	}
	
}
