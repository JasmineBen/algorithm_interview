package com.datastructure.exercise;

import java.util.Stack;

/**
 * ��ջ��������ʵ�ֶ������ײ��ĴӴ�С
 * ֻ��������һ������ջ������ı��������������������ݽṹ
 * @author zhoupeiyuan
 *
 */
public class SortStack {

	/**
	 * ����һ��helpջ
	 * 1�����ԭջ��Ϊ�գ�ȡ��ԭջջ��top
	 * 2�����helpΪ�գ��ͽ�topѹ��helpջ
	 * 3�����help��Ϊ�գ��ͱȽ�top��help��ջ�������helpջ��С��top��
	 * �ͽ�help��ջ��ѹ��ԭջ��ֱ��help��ջ��Ԫ�ش��ڵ���topֵ
	 * 4����topѹ��helpջ
	 * 5��ѭ������ԭջ��ջ�������ջ��Ԫ��С�ڵ���top���ͽ�ԭջջ����Ԫ��ѹ��helpջ
	 * 6�����ԭջ���е����ݶ��Ѿ�����helpջ�У��Ҵ��ϵ����Ǵ�С�����˳��
	 * 7����helpջ�е�Ԫ��ѹ��ԭջ����ʵ����ԭջ�ĳ��С����
	 */
	public static void sort(Stack<Integer> stack){
		Stack<Integer> help = new Stack<>();
		while(!stack.isEmpty()){
			int top = stack.pop();
			if(help.isEmpty()){
				help.push(top);
			}else{
				while(!help.isEmpty()&&top>help.peek()){
					stack.push(help.pop());
				}
				help.push(top);
				while(!stack.isEmpty()&&top >= stack.peek() ){
					help.push(stack.pop());
				}
			}
		}
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 10;i>=1;i--){
			stack.push(i);
		}
		sort(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
