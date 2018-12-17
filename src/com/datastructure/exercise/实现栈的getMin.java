package com.datastructure.exercise;

import java.util.Stack;

/**
 * 设计一个特殊的栈，在实现栈的功能的基础上，实现getMin功能。
 * 要求:pop push getMin的时间复杂度都是O(1)
 * 可以使用现有的栈结构
 * @author zhoupeiyuan
 *
 */
public class 实现栈的getMin {
	
	//保存源数据
	private Stack<Integer> mDataStack = new Stack<>();
	//保存最小值
	private Stack<Integer> mMinStack = new Stack<>();

	/**
	 * 使用两个栈，一个保存数据mDataStack，一个保存最小值mMinStack
	 * push:将数据存入mDataStack,mMinStack有如下几种场景：
	 * 1、mMinStack为空，直接将数据push到mMinStack
	 * 2、mMinStack不为空，比较mMinStack的栈顶元素和item,如果item大，
	 * 就将mMinStack的栈顶元素再次插入，否则插入item到mMinStack。
	 * 
	 * pop:将mMinStack的栈顶元素弹出，将mDataStack的栈顶元素弹出并返回。
	 * 
	 * getMin:返回mMinStack的栈顶元素，不弹出。
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
		实现栈的getMin stack = new 实现栈的getMin();
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
