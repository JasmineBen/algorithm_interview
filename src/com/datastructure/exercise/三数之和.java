package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 *[
 * [-1, 0, 1],
 * [-1, -1, 2]
 *]
 *
 */
public class 三数之和 {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> results = new 三数之和().threeSum(nums);
		for(List<Integer> item : results) {
			for(Integer i : item) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

	/**
	 * 这是一个3-sum问题
	 * a+b+c=0,则a=-(b+c),则问题转化成在数组a[n]中寻找a[i]=-(a[j]+a[k]),
	 * 进而转化为a[j]+a[k]的2-sum问题
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
		//快速排序
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
	 * 一趟快速排序的算法是：
	 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
	 * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
	 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
	 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
	 * 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
	 * 使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。
	 * 另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
	 */
	private int partition(int[] a, int start, int end) {
		int key = a[start];
		while (start < end) {//扫描顺序不能错
			while(a[end] >= key && start < end){//从后往前扫描
				end -- ;
			}
			a[start] = a[end];
			
			while(a[start] <= key && start < end){//从前往后扫描
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
