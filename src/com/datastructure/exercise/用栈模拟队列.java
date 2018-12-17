package com.datastructure.exercise;

import java.util.Stack;

/**
 * ��ջģ����еĲ���
 * @author zhoupeiyuan
 *
 */
public class ��ջģ����� {
	
	//ѹ��ջ
	private Stack<Integer> mStackPush = new Stack<>();
	//����ջ
	private Stack<Integer> mStackPop = new Stack<>();

	/**
	 * ����ѹ��ջmStackPush�͵���ջmStackPop��ʵ�ֶ��й���
	 * add��������ѹ��mStackPush����
	 * poll:���ڶ������Ƚ��ȳ�����ջ���Ƚ����������ֻ��Ҫ��mStackPush������
	 * ����ѹ��mStackPop����ʵ��mStackPush�ĵ������mStackPop���������ݣ�
	 * ֻ��Ҫ��mStackPop�����ݵ������ɣ�����mStackPushȫ��ѹ��mStackPop��
	 * ��󵯳�mStackPop��ջ��Ԫ�ز����ء�
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
		��ջģ����� queue = new ��ջģ�����();
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
