package com.datastructure.exercise;

import java.util.Stack;

/**
 * 仅使用递归函数完成栈的翻转，不能使用额外的数据结构
 * @author zhoupeiyuan
 *
 */
public class 递归翻转栈 {

	/**
	 * 1、将栈底的元素删除
	 * 2、将栈中的剩余内容进行翻转
	 * 3、将第1步中的元素插入栈中
	 */
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int lastElement = getAndRemoveBottomElement(stack);
		reverse(stack);
		stack.push(lastElement);
	}
	
	/**
	 * 删除栈底元素
	 * 1、  取出栈顶元素，如果栈空了，说明栈里面只有一个元素，进行返回即可
	 * 2、 如果取出栈顶后不为空，说明栈里面的元素大于1，对剩余的元素进行递归
	 * 3、 将第1步取出的栈顶元素压入栈，保证只会删除栈底额元素
	 */
	public static int getAndRemoveBottomElement(Stack<Integer> stack){
		int top = stack.pop();
		if(!stack.isEmpty()){
			 int bottom = getAndRemoveBottomElement(stack);
			 stack.push(top);
			 return bottom;
		}
		return top;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 1;i<10;i++){
			stack.push(i);
		}
		reverse(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());	
		}
		
	}
}
