package com.datastructure.exercise;

import java.util.LinkedList;

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
		int num[] = new int[]{8,7,6,5,4,3,2,1};
		int num1[] = new int[]{1,2,3,4,5,6,7,8};
		int num2[] = new int[]{2,3,4,2,6,2,5,1};
		MaxInWindows test = new MaxInWindows();
		int[] result = test.maxInWindows(num, 3);
		int[] result1 = test.maxInWindows(num1, 3);
		int[] result2 = test.maxInWindows(num2, 3);
		for(int i : result){
			System.out.print(num[i]+",");
		}
		System.out.println();
		for(int i : result1){
			System.out.print(num1[i]+",");	
		}
		System.out.println();
		for(int i : result2){
			System.out.print(num2[i]+",");	
		}
	}
	
	/**
	 * 使用双端队列来保存，队首始终保存当前滑动窗口的最大值
	 */
	public int[] maxInWindows(int[] num, int size) {
		int[] result = new int[num.length-size+1];
		LinkedList<Integer> pox = new LinkedList<>();
		for(int i = 0;i<num.length;i++){
			//删除队尾小于等于num[i]的元素
			while(!pox.isEmpty() && num[pox.peekLast()]<=num[i]){
				pox.pollLast();
			}
			pox.offerLast(i);
			//删除对首过期的元素
			if(i-pox.peekFirst()==size){
				pox.pollFirst();
			}
			if(i>=size-1){//不能使用poll，因为该元素还可能出现在下一个滑动窗口
				result[i+1-size] = pox.peekFirst();
			}
		}
		return result;
	}
	
}
