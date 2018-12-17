package com.datastructure.exercise;

import java.util.Stack;

/**
 * 用栈模拟队列的操作
 * @author zhoupeiyuan
 *
 */
public class 用栈模拟队列 {
	
	//压入栈
	private Stack<Integer> mStackPush = new Stack<>();
	//弹出栈
	private Stack<Integer> mStackPop = new Stack<>();

	/**
	 * 采用压入栈mStackPush和弹出栈mStackPop来实现队列功能
	 * add：将数据压入mStackPush即可
	 * poll:由于队列是先进先出，而栈是先进后出，所以只需要将mStackPush的内容
	 * 依次压入mStackPop即可实现mStackPush的倒序，如果mStackPop里面有内容，
	 * 只需要将mStackPop的内容弹出即可，否则将mStackPush全部压入mStackPop，
	 * 最后弹出mStackPop的栈顶元素并返回。
	 * 
	 */
	public void add(Integer item){
		mStackPush.push(item);
	}
	
	public int poll(){
		if(mStackPush.isEmpty() && mStackPop.isEmpty()){
			throw new RuntimeException("queue is empty");
		}
		if(!mStackPop.isEmpty()){
			return mStackPop.pop();
		}
		while(!mStackPush.isEmpty()){
			mStackPop.add(mStackPush.pop());
		}
		return mStackPop.pop();
	}
	
	public int peek(){
		if(mStackPush.isEmpty() && mStackPop.isEmpty()){
			throw new RuntimeException("queue is empty");
		}
		if(!mStackPop.isEmpty()){
			return mStackPop.peek();
		}
		while(!mStackPush.isEmpty()){
			mStackPop.add(mStackPush.pop());
		}
		return mStackPop.peek();
	}
	
	public static void main(String[] args) {
		用栈模拟队列 queue = new 用栈模拟队列();
		queue.add(1);
		queue.add(2);
		System.out.println(queue.poll());
		queue.add(3);
		System.out.println(queue.poll());
		queue.add(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
