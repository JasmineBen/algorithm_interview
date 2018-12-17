package com.datastructure.exercise;

import java.util.Stack;

/**
 * ���һ�������ջ����ʵ��ջ�Ĺ��ܵĻ����ϣ�ʵ��getMin���ܡ�
 * Ҫ��:pop push getMin��ʱ�临�Ӷȶ���O(1)
 * ����ʹ�����е�ջ�ṹ
 * @author zhoupeiyuan
 *
 */
public class ʵ��ջ��getMin {
	
	//����Դ����
	private Stack<Integer> mDataStack = new Stack<>();
	//������Сֵ
	private Stack<Integer> mMinStack = new Stack<>();

	/**
	 * ʹ������ջ��һ����������mDataStack��һ��������СֵmMinStack
	 * push:�����ݴ���mDataStack,mMinStack�����¼��ֳ�����
	 * 1��mMinStackΪ�գ�ֱ�ӽ�����push��mMinStack
	 * 2��mMinStack��Ϊ�գ��Ƚ�mMinStack��ջ��Ԫ�غ�item,���item��
	 * �ͽ�mMinStack��ջ��Ԫ���ٴβ��룬�������item��mMinStack��
	 * 
	 * pop:��mMinStack��ջ��Ԫ�ص�������mDataStack��ջ��Ԫ�ص��������ء�
	 * 
	 * getMin:����mMinStack��ջ��Ԫ�أ���������
	 */
	public void push(Integer item){
		if(mMinStack.isEmpty()){
			mMinStack.push(item);
		}else if(item <= mMinStack.peek()){
			mMinStack.push(item);
		}else{
			mMinStack.push(mMinStack.peek());
		}
		mDataStack.push(item);
	}
	
	public int pop(){
		if(mDataStack.isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		mMinStack.pop();
		return mDataStack.pop();
	}
	
	public int getMin(){
		if(mMinStack.isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		return mMinStack.peek();
	}
	
	public static void main(String[] args) {
		int[] input = {3,5,4,1,2,1};
		ʵ��ջ��getMin stack = new ʵ��ջ��getMin();
		stack.push(3);
		System.out.println("min:"+stack.getMin());
		stack.pop();
		stack.push(4);
		stack.push(5);
		System.out.println("min:"+stack.getMin());
		stack.pop();
		stack.push(1);
		System.out.println("min:"+stack.getMin());
		stack.push(2);
		stack.push(1);
		stack.pop();
		System.out.println("min:"+stack.getMin());
		stack.pop();
		System.out.println("min:"+stack.getMin());
		stack.pop();
		System.out.println("min:"+stack.getMin());
	}
}
