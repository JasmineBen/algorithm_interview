package com.datastructure.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 *
 */
public class GetMedian {
	//�Ӵ�С
	private PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(11,new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		};
	});
	//��С����
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
		//ż�����small��larger��sizeһ��
		if(smaller.size()  ==  larger.size() + 2){
			larger.offer(smaller.poll());
		}else if(smaller.size() + 1 == larger.size()){//�������small��larger��1
			smaller.offer(larger.poll());
		}
		System.out.println(smaller.peek() + " "+(larger.isEmpty() ? -1:larger.peek()));
	}

	public Double GetMedian() {
		return smaller.size() == larger.size() ? (smaller.peek() + larger.peek())/2.0 : smaller.peek();
	}
}
