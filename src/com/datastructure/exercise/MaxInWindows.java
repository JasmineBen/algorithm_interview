package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 */
public class MaxInWindows {
	
	public static void main(String[] args) {
		int num[] = new int[]{2,3,4,2,6,2,5,1};
		MaxInWindows test = new MaxInWindows();
		ArrayList<Integer> result = test.maxInWindows(num, 0);
		for(int i : result){
			System.out.println(i);
		}
	}
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num != null && num.length >= size && size>0) {
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size,new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			for(int i = 0;i< num.length - size + 1;i++){
				for(int j = i;j<size+i;j++){
					queue.offer(num[j]);
				}
				result.add(queue.poll());
				queue.clear();
			}
		}
		return result;
	}
	
}
