package com.datastructure.exercise;

/**
 * ����
 */
public class ���� {
	
	public static void main(String[] args) {
		int[] a = new int[]{5,3,6,2,7,1,4,0,9,8};
//		int[] a = new int[]{1,2,3,4,5,6,7,8,9};
//		quickSort(a);
//		bubbleSort(a);
		//selectSort(a);
//		insertSort(a);
		mergeSort(a);
//		heapSort(a);
		for(int i : a){
			System.out.println(i);
		}
	}
	
	
	/**
	 * ð������
	 * ����������鴹ֱ����a[0-n],�����ݲ�����������֮��
	 * ��һ������a[0]��a[n]�����Աȣ����a[i]>a[i+1],��ô�ͽ���,����������Ԫ�ؾ���a[n]λ��
	 * �ڶ�������a[0]��a[n-1]�����Ա����a[i]>a[i+1],��ô�ͽ���������������Ԫ�ؾ���a[n-1]λ��
	 * �Դ����ƣ����һ�ν�a[0]��a[1]�Աȣ��������ֵ��a[1]
	 * 
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j] < a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * ѡ������
	 * ��һ�����򣬽�a[1]��a[n]��Ԫ�غ�a[0]�Աȣ������a[0]С�ͺ�a[0]������һ����������a[0]������Сֵ
	 * �ڶ������򣬽�a[2]��a[n]��Ԫ�غ�a[1]�Աȣ�����С��ֵ��a[1],һ����������a[1]������Сֵ
	 * �Դ����ƣ�����Դ˽�a[n-1]��a[n]�Աȣ����a[n-1]>a[n]�ͽ���������ֵ
	 * @param a
	 */
	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	
	/**
	 * ��������
	 * �ӵ�һ��Ԫ�ؿ�ʼ�����϶�Ϊ�����
	 * a[0],a[1]....a[i-1],a[i],...a[n]
	 * a[0]��a[i]�Ѿ�������ģ�for(int j=i-1,j>=0;j--),
	 * ���a[j]>a[i],��a[j]-a[i-1]������ƶ���
	 * ���a[j]<a[i]��ѭ������
	 * @param a
	 */
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j;
			for (j = i - 1; j >= 0 && tmp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j+1] = tmp;

		}
	}
	
	/**
	 * �鲢����
	 * @param a
	 */
	public static void mergeSort(int[] a){
		int[] tmp = new int[a.length];
		mergeSort(a, 0, a.length-1, tmp);
	}
	
	private static void mergeSort(int[] a, int first,int last, int[] tmp) {
		if(first < last){
			int mid = (first+last)/2;
			mergeSort(a, first, mid, tmp);
			mergeSort(a, mid+1, last, tmp);
			merge(a, first, mid, last, tmp);
		}
		
	}
	
	/**
	 * ��������������a[first...mid],a[mid+1...last]�ϲ�
	 * @param a
	 * @param first
	 * @param mid
	 * @param last
	 * @param tmp
	 */
	private static void merge(int[] a, int first, int mid, int last, int[] tmp) {
		int i = first, j = mid + 1;
		int k = 0;
		while (i <= mid && j <= last) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}

		while (i <= mid) {
			tmp[k++] = a[i++];
		}

		while (j < a.length) {
			tmp[k++] = a[j++];
		}

		for (i = 0; i < k; i++) {//������ԭ����
			a[first + i] = tmp[i];
		}
	}
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}
	
	
	private static void quickSort(int[] a,int start,int end){
		if(start >= end){
			return;
		}
		int partition = partition(a, start, end);
		quickSort(a, start, partition-1);
		quickSort(a, partition + 1, end);
	}
	
	/**
	 * һ�˿���������㷨�ǣ�
	 * 1��������������i��j������ʼ��ʱ��i=0��j=N-1��
	 * 2���Ե�һ������Ԫ����Ϊ�ؼ����ݣ���ֵ��key����key=A[0]��
	 * 3����j��ʼ��ǰ���������ɺ�ʼ��ǰ����(j--)���ҵ���һ��С��key��ֵA[j]����A[j]��A[i]������
	 * 4����i��ʼ�������������ǰ��ʼ�������(i++)���ҵ���һ������key��A[i]����A[i]��A[j]������
	 * 5���ظ���3��4����ֱ��i=j�� (3,4���У�û�ҵ�����������ֵ����3��A[j]��С��key,4��A[i]������key��ʱ��ı�j��i��ֵ��
	 * ʹ��j=j-1��i=i+1��ֱ���ҵ�Ϊֹ���ҵ�����������ֵ�����н�����ʱ��i�� jָ��λ�ò��䡣
	 * ���⣬i==j��һ����һ��������i+��j-��ɵ�ʱ�򣬴�ʱ��ѭ����������
	 */
	private static int partition(int[] a, int start, int end) {
		int key = a[start];
		while (start < end) {//ɨ��˳���ܴ�
			while(a[end] >= key && start < end){//�Ӻ���ǰɨ��
				end -- ;
			}
			a[start] = a[end];
			
			while(a[start] <= key && start < end){//��ǰ����ɨ��
				start ++;
			}
			a[end] = a[start];			
		}
		a[end] = key;
		return end;
	}
	
	/**
	 * ����ѣ����ڵ��ֵ������������,��������ȫ��������
	 * ������ղ�α����������õ�����arr,��ôa[i]>=a[2i+1] �� a[i]>=a[2i+2]��
	 * ʵ�ֶ����������ǽ��ѣ��ӷ�Ҷ�ӽڵ㿪ʼ����С���ϣ����ҵ������
	 */
	public static void heapSort(int[] arr){
		if(arr != null){
			//����
			for(int i = arr.length/2-1;i>=0;i--){
				adjustHeap(arr, i, arr.length);
			}
			
			//�����ѣ������Զ�Ԫ�غ�ĩβԪ��
			for(int i=arr.length-1;i>=0;i--){
				swap(arr, 0, i);//�����Ѷ���ĩβԪ��
				//������ɺ���Ҫ������
				adjustHeap(arr, 0, i);
			}
			
		}
	}
	
	//�����ѣ�
	private static void adjustHeap(int[] arr, int i, int len) {
		int tmp = arr[i];
		/**
		 * ��i�����ӿ�ʼ��Ҳ����2i+1,��ʼ��С���������a[i]С����ڵ�a[2i+1]�����ҽڵ�a[2i+2]��
		 * ��ô�ͽ���a[i]��max(a[2i+1],a[2i+2]),�����a[2i+1]�����ˣ�
		 * ��ô��a[2i+1]Ϊ��������������ʧȥƽ�⣬��Ҫ��������a[2i+1]������a[2(2i+1)+1],a[2(2i+1)+2]
		 */
		for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
			if(j+1<len &&arr[j] < arr[j+1]){//a[2i+1]<a[2i+2],a[i]��a[2i+2����]
				j++;
			}
			if(tmp < arr[j]){
				arr[i] = arr[j];//����a[i]��max(a[2i+1],a[2i+2])
				i = j;
			}else{
				break;
			}
		}
		arr[i] = tmp;

	}
	
	
	//��������a������λ�õ�Ԫ��
	private static void swap(int[] a,int indexA,int indexB){
		int temp = a[indexA];
		a[indexA] = a[indexB];
		a[indexB] = temp;
	}

}
