package com.datastructure.exercise;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
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
