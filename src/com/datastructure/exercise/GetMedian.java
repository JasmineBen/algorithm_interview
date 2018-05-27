package com.datastructure.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */
public class GetMedian {
	//从大到小
	private PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(11,new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		};
	});
	//从小到大
	private PriorityQueue<Integer> larger = new PriorityQueue<Integer>(11,new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		};
	});
	
	public static void main(String[] args) {
		int[] a = new int[]{5,3,2,4};
		GetMedian test = new GetMedian();
		for(int i = 0;i<a.length;i++){
			test.Insert(a[i]);
		}
	}

	public void Insert(Integer num) {
		if(smaller.isEmpty() || num < smaller.peek()){
			smaller.offer(num);
		}else{
			larger.offer(num);
		}
		//偶数情况small和larger的size一样
		if(smaller.size()  ==  larger.size() + 2){
			larger.offer(smaller.poll());
		}else if(smaller.size() + 1 == larger.size()){//奇数情况small比larger大1
			smaller.offer(larger.poll());
		}
		System.out.println(smaller.peek() + " "+(larger.isEmpty() ? -1:larger.peek()));
	}

	public Double GetMedian() {
		return smaller.size() == larger.size() ? (smaller.peek() + larger.peek())/2.0 : smaller.peek();
	}
}
