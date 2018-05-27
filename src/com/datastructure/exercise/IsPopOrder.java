package com.datastructure.exercise;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 */
public class IsPopOrder {

	public static void main(String[] args) {
		int[] push = new int[]{1,2,3,4,5};
		int[] pop = new int[]{4,5,3,2,1};
		int[] pop2 = new int[]{4,3,5,1,2};
		IsPopOrder test = new IsPopOrder();
		System.out.println(test.isPopOrder(push, pop));
		System.out.println(test.isPopOrder(push, pop2));
	}
	
	public boolean isPopOrder(int[] push,int[] pop){
		if(push == null || pop == null || push.length != pop.length){
			return false;
		}
		Stack<Integer> temp = new Stack<>();
		int popIndex = 0;
		for(int i = 0;i<push.length;i++){
			temp.push(push[i]);
			while(!temp.isEmpty() && temp.peek() == pop[popIndex]){
				popIndex ++;
				temp.pop();
			}
		}
		return temp.isEmpty();
	}
}
