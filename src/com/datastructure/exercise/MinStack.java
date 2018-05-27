package com.datastructure.exercise;

import java.util.Stack;

/**
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 要求O(1)时间复杂度
 */
public class MinStack {
	
	Stack<Integer> data = new Stack<Integer>();//源数据存放栈
	Stack<Integer> min = new Stack<Integer>();//辅助栈

	public void push(int node) {
		if(min.isEmpty()){
			min.push(node);//压入辅助栈
		}else{
			//辅助栈顶的元素大于即将压入的元素，将新的最小值压入辅助栈
			if(min.peek() > node){
				min.push(node);
			}else{
				//将当前辅助栈顶的栈顶再次压入，就算pop后，最小元素还在栈顶
				min.push(min.peek());
			}
		}
		data.push(node);//压入数据栈
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
