package com.datastructure.exercise;

import java.util.Stack;

/**
 *������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡� 
 */
public class SimulateQueueByStack {

	//pushʱ��ѹ��ջ
	Stack<Integer> stack1 = new Stack<Integer>();
	//popʱ�� ����ջ
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
     * ѹ��ʱ��� stack2Ϊ�գ���˵������Ҫ��ջ��ֱ��ѹ��stack1
     * ��֮stack2��Ϊ�գ���Ҫ�Ƚ�stack2��������ݵ���stack1���ٽ�����ѹ��stack1
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
     * ���stack1Ϊ�գ���ֱ�ӵ���stack2
     * ��֮���stack1��Ϊ�գ���Ҫ��stack1�е�Ԫ��ѹ��stack2,������stack1�������Ԫ��
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
