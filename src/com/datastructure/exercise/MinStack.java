package com.datastructure.exercise;

import java.util.Stack;

/**
 * 
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * Ҫ��O(1)ʱ�临�Ӷ�
 */
public class MinStack {
	
	Stack<Integer> data = new Stack<Integer>();//Դ���ݴ��ջ
	Stack<Integer> min = new Stack<Integer>();//����ջ

	public void push(int node) {
		if(min.isEmpty()){
			min.push(node);//ѹ�븨��ջ
		}else{
			//����ջ����Ԫ�ش��ڼ���ѹ���Ԫ�أ����µ���Сֵѹ�븨��ջ
			if(min.peek() > node){
				min.push(node);
			}else{
				//����ǰ����ջ����ջ���ٴ�ѹ�룬����pop����СԪ�ػ���ջ��
				min.push(min.peek());
			}
		}
		data.push(node);//ѹ������ջ
	}

	public void pop() {
		int a = data.pop();
		int b = min.pop();
	}

	public int top() {
		return data.peek();
	}

	public int min() {
		return min.peek();
	}
}
