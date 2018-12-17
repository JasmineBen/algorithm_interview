package com.datastructure.exercise;

import java.util.Stack;

/**
 * ��ʹ�õݹ麯�����ջ�ķ�ת������ʹ�ö�������ݽṹ
 * @author zhoupeiyuan
 *
 */
public class �ݹ鷭תջ {

	/**
	 * 1����ջ�׵�Ԫ��ɾ��
	 * 2����ջ�е�ʣ�����ݽ��з�ת
	 * 3������1���е�Ԫ�ز���ջ��
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
	 * ɾ��ջ��Ԫ��
	 * 1��  ȡ��ջ��Ԫ�أ����ջ���ˣ�˵��ջ����ֻ��һ��Ԫ�أ����з��ؼ���
	 * 2�� ���ȡ��ջ����Ϊ�գ�˵��ջ�����Ԫ�ش���1����ʣ���Ԫ�ؽ��еݹ�
	 * 3�� ����1��ȡ����ջ��Ԫ��ѹ��ջ����ֻ֤��ɾ��ջ�׶�Ԫ��
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
