package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 * @author admin
 *
 */
public class GetLeastNumbers {

	public static void main(String[] args) {
		int[] input = new int[]{1,2,3};
		GetLeastNumbers test = new GetLeastNumbers();
		ArrayList<Integer> result = test.GetLeastNumbers_Solution(input, 3);
		for(int a : result){
			System.out.println(a);
		}
	}

	private int Partition(int[] input, int begin, int end) {
		int low = begin;
		int high = end;
		int pivot = input[low];
		while (low < high) {
			while (low < high && pivot <= input[high]) {
				high--;
			}
			input[low] = input[high];
			while (low < high && pivot >= input[low]) {
				low++;
			}
			input[high] = input[low];
		}
		input[low] = pivot;
		return low;
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if(input == null || input.length == 0 || k > input.length || k <= 0){
			return new ArrayList<Integer>();
		}
		if(k == input.length){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i : input){
				list.add(i);
			}
			return list;
		}else{
			int begin = 0;
			int end = input.length -1;
			int partion = Partition(input, begin,end);
			while(partion != k-1){
				if(partion < k-1){
					begin = partion + 1;
					partion = Partition(input,begin,end);
				}else if(partion > k-1){
					end = partion - 1;
					partion = Partition(input,begin,end);
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0;i<k;i++){
				list.add(input[i]);
			}
			return list;
		}
	}
	
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		if(input == null || input.length == 0 || k > input.length || k <= 0){
			return new ArrayList<Integer>();
		}
		if(k == input.length){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i : input){
				list.add(i);
			}
			return list;
		}else{
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			for(int i : input){
				queue.add(i);
			}
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 0;i<k;i++){
				result.add(queue.poll());
			}
			return result;
		}
	}
}
