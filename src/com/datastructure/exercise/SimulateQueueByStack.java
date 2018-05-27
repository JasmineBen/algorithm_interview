package com.datastructure.exercise;

import java.util.Stack;

/**
 *用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。 
 */
public class SimulateQueueByStack {

	//push时的压入栈
	Stack<Integer> stack1 = new Stack<Integer>();
	//pop时的 辅助栈
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public static void main(String[] args) {
		SimulateQueueByStack simulate = new SimulateQueueByStack();
		for(int i = 0;i<5;i++){
			simulate.push(1);
		}
		System.out.println(simulate.stack1.size());
		System.out.println(simulate.stack2.size());
		for(int i = 0;i<5;i++){
			simulate.pop();
		}
	}
    
 
    /**
     * 压入时如果 stack2为空，则说明不需要倒栈，直接压入stack1
     * 反之stack2不为空，需要先将stack2里面的内容倒入stack1，再将数据压入stack1
     */
	public void push(int node) {
		int stack2Size = stack2.size();
		while (stack2Size > 0) {
			stack1.push(stack2.pop());
			stack2Size--;
		}
		stack1.push(node);
	}
    
    /**
     * 如果stack1为空，则直接弹出stack2
     * 反之如果stack1不为空，需要讲stack1中的元素压入stack2,并弹出stack1最下面的元素
     */
    public int pop() {
    	int stack1Size = stack1.size();
//    	while(!stack1.isEmpty()){
//    		stack2.push(stack1.pop());
//    	}
    	while(stack1Size > 1){
    		stack2.push(stack1.pop());
    		stack1Size --;
    	}
    	return stack1.isEmpty()? stack2.pop():stack1.pop();
    }
}
