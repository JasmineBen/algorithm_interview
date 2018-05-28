package com.datastructure.exercise;

import java.util.Stack;

/**
 * 对栈进行排序，实现顶部到底部的从大到小
 * 只允许申请一哥额外的栈和其余的变量，不许申请额外的数据结构
 * @author zhoupeiyuan
 *
 */
public class SortStack {

	/**
	 * 引入一个help栈
	 * 1、如果原栈不为空，取出原栈栈顶top
	 * 2、如果help为空，就将top压入help栈
	 * 3、如果help不为空，就比较top和help的栈顶，如果help栈顶小于top，
	 * 就将help的栈顶压入原栈，直到help的栈顶元素大于等于top值
	 * 4、将top压入help栈
	 * 5、循环变量原栈的栈顶，如果栈顶元素小于等于top，就将原栈栈顶的元素压入help栈
	 * 6、最后原栈所有的内容都已经到了help栈中，且从上到下是从小到达的顺序
	 * 7、将help栈中的元素压入原栈，就实现了原栈的充大到小排列
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
