package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;


/**
 * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣ע�⣺���в����԰����ظ�����Ԫ�顣
 * ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
 * ����Ҫ�����Ԫ�鼯��Ϊ��
 *[
 * [-1, 0, 1],
 * [-1, -1, 2]
 *]
 *
 */
public class ����֮�� {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> results = new ����֮��().threeSum(nums);
		for(List<Integer> item : results) {
			for(Integer i : item) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

	/**
	 * ����һ��3-sum����
	 * a+b+c=0,��a=-(b+c),������ת����������a[n]��Ѱ��a[i]=-(a[j]+a[k]),
	 * ����ת��Ϊa[j]+a[k]��2-sum����
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
		//��������
		quickSort(nums, 0, nums.length-1);
		List<Pair> threePair = new ArrayList<>();
		List<List<Integer>> finalResult = new ArrayList<>();
		for (int index = 0; index < nums.length; index++) {
			List<Pair> result = computeTwoSum(nums, - nums[index], index);
			for (Pair p : result) {
				p.middle = nums[index];
				p.sort();
				if (!threePair.contains(p)) {
					threePair.add(p);
					finalResult.add(p.toList());
				}
			}
		
		}
		return finalResult;

	}
	
	
	private void quickSort(int[] a,int start,int end){
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
	private int partition(int[] a, int start, int end) {
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
	
	private  List<Pair> computeTwoSum(int[] a, int target,int currentIndex) {
		List<Pair> result = new ArrayList<>();
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			if(start == currentIndex){
				start ++;
			}
			if(end == currentIndex){
				end --;
			}
			if(start >= end){
				break;
			}
			int sum = a[start] + a[end];
			if (sum == target) {
				result.add(new Pair(a[start],-1,a[end]));
				start++;
				end--;
			}else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return result;
	}
	
	public class Pair{
		int min;
		int middle;
		int max;

		
		
		public Pair(int min, int middle, int max) {
			super();
			this.min = min;
			this.middle = middle;
			this.max = max;
		}
		
		public void sort() {
			int aMin = Math.min(min, middle);
			int bMax = Math.max(middle, max);
			int cMidddle = middle;
			if(aMin < min) {
				middle = min;
			}else if(bMax > max) {
				middle = max;
			}
			min = aMin;
			max = bMax;
		}

		public List<Integer> toList(){	
			List<Integer> item = new ArrayList<>();
			item.add(min);
			item.add(middle);
			item.add(max);
			return item;
		}


		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Pair)){
				return false;
			}
			Pair other = (Pair)obj;
			return other.min == this.min 
					&& other.middle == this.middle 
					&& other.max == this.max;
		}
	}

}
