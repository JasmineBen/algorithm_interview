package com.datastructure.basic;

import java.util.Stack;

/**
 * ���ʽ
 * 
 * @author admin
 *
 */
public class Expression {

	public static void main(String[] args) {
		Expression test = new Expression();
		String input = "2*3/(2-1)+3*(4-1)";
		System.out.println(test.computePostOrderExpression(input));
		System.out.println(test.computePreOrderExpression(input));
	}
	
	/**
	 * ��������ʽת��Ϊǰ��Ȼ���ټ���
	 * ����������ȡ����ֱ��ȡ��һ�������������ȡ���Ľ��������������������������������м��㣬
	 * �����������������ظ��ò��裬ֱ�����ֻʣ��һ���ַ�����ʣ�µ��ַ�����Ϊ���
	 */
	private int computePreOrderExpression(String input) {
		String preOrder = preOrder(input);
		System.out.println(preOrder);
		char[] chars = preOrder.toCharArray();
		Stack<Integer> dataStack = new Stack<>();
		for(int i = chars.length-1;i>=0;i--){
			char c = chars[i];
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {
				// ������ֱ��ѹ��
				dataStack.push(Integer.valueOf(c+""));
			}else if(c == '+' || c == '-' || c == '*' || c == '/' ){
				int first = dataStack.pop();
				int second = dataStack.pop();
				if(c == '+'){
					dataStack.push(first+second);
				}else if(c == '-'){
					dataStack.push(first-second);
				}else if(c == '*'){
					dataStack.push(first*second);
				}else if(c == '/'){
					dataStack.push(first/second);
				}
			}
		}
		return dataStack.pop();
	}

	/**
	 * �����˺�׺���ʽ�Ժ�������ʽ��ֵ�ͷǳ������ˡ����԰�����������������㡣
	 * ��1����������ɨ����ʽ��һ��ȡ��һ������data
	 * ��2�����data�ǲ���������ѹ���ջ
	 * ��3�����data�ǲ��������ʹӶ�ջ�е����˲�������Ҫ�õ������ݵĸ������������㣬Ȼ��ѽ��ѹ���ջ
	 * ��4��������ݴ�����ϣ���ջ�����ʣ������ݾ������ս����
	 */
	private int computePostOrderExpression(String input) {
		String postOrder = postOrder(input);
		System.out.println(postOrder);
		char[] chars = postOrder.toCharArray();
		Stack<Integer> dataStack = new Stack<>();
		for(char c : chars){
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {
				// ������ֱ��ѹ��
				dataStack.push(Integer.valueOf(c+""));
			}else if(c == '+' || c == '-' || c == '*' || c == '/' ){
				int second = dataStack.pop();
				int first = dataStack.pop();
				if(c == '+'){
					dataStack.push(first+second);
				}else if(c == '-'){
					dataStack.push(first-second);
				}else if(c == '*'){
					dataStack.push(first*second);
				}else if(c == '/'){
					dataStack.push(first/second);
				}
			}
		}
		return dataStack.pop();
	}

	/**
	 * ��׺���ʽ����ɺ�׺���ʽ�ķ������£�
	 * ��1��������������ȡ������ch��
	 * ��2�����ch�ǲ�������ֱ�������
	 * ��3�����ch������������������ţ�����
	 *      a�����ch = '('�������ջ��
	 * 	    b�����ch = ')'�����������ջ�е��������ֱ������'('Ϊֹ��
	 *      c�����ch����')'����'('����ô�ͺͶ�ջ����λ�õ������top�����ȼ��Ƚϡ�
	 *         1�����ch���ȼ���top�ߣ���ô��ch�����ջ��
	 *         2�����ch���ȼ����ڻ��ߵ���top����ô���top��Ȼ��ch�����ջ��
	 * ��4��������ʽ�Ѿ���ȡ��ɣ�����ջ�л��������ʱ�������ɶ��������
	 */
	private String postOrder(String input) {
		char[] chars = input.toCharArray();
		Stack<Opt> optStack = new Stack<>();
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {
				// ������ֱ�����
				output.append(String.valueOf(c));
			} else {// ������
				Opt opt = new Opt(c);
				if (c == '(') {// ������ֱ��ѹ���ջ
					optStack.push(opt);
				} else if (c == ')') {
					while (!optStack.isEmpty()&&'('!=optStack.peek().val) {
						output.append(optStack.pop().val);
					}
					if('('==optStack.peek().val){
						optStack.pop();
					}
				} else {//"+-*/"
					while(!optStack.isEmpty()&&opt.priority<=optStack.peek().priority){
						output.append(optStack.pop().val);
					}
					optStack.push(opt);
				}
			}
		}
		while(!optStack.isEmpty()){
			char c = optStack.pop().val;
			output.append(c);
		}
		return output.toString();
	}
	
	/**
	 * 1����ת�����ַ������硰2*3/(2-1)+3*(4-1)�� ��ת��Ϊ�� )1-4(*3+)1-2(/3*2����
	 * 2�����ַ�����ȡ����һ���ַ�
����			2.1.����ǲ���������ֱ�����
����			2.2.����ǡ�)����ѹ��ջ��
����			2.3.���������������ǡ�(������)��,�򲻶�ѭ���������´���
��������			2.3.1.���ջΪ�գ�����������ջ�������˲���
��������			2.3.2.���ջ���ǡ�)��,����������ջ�������˲���
��������			2.3.2.������������ջ�����ȼ���ͬ���߸��ߣ����������ջ�������˲���
��������			2.3.4.���������������ջ�����ֱ������������������֮һ��Ȼ����������ջ
����			2.4������ǡ�(�����������������ջ�����ֱ��������)��Ϊֹ,����)����ջ�Ҷ���֮
	  3��������и�����ַ�������ת����2��
      4��������δ������ַ����ˣ����ջ��ʣ��Ԫ��
      5���ٴη�ת�ַ����õ����ս��
	 */
	private String preOrder(String input){
		Stack<String> output = new Stack<>();
		Stack<Opt> optStack = new Stack<>();
		char[] chars = input.toCharArray();
		for(int i = chars.length -1;i>=0;i--){
			char c = chars[i];
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {//2.1
				// ������ֱ�����
				output.push(String.valueOf(c));
			}else if(')'==c){//2.2
				optStack.push(new Opt(c));
			}else if('('==c){//2.4
				while (!optStack.isEmpty()&&')'!=optStack.peek().val) {
					output.push(String.valueOf(optStack.pop().val));
				}
				if(')'==optStack.peek().val){
					optStack.pop();
				}
			}else{//2.3
				Opt opt = new Opt(c);
				if(optStack.isEmpty() || optStack.peek().val == ')'){
					optStack.push(opt);
				}else{
					while(true){
						if(optStack.isEmpty() || optStack.peek().val == ')'){
							optStack.push(opt);
							break;
						}else if(opt.priority>=optStack.peek().priority){
							optStack.push(opt);
							break;
						}else{
							output.push((String.valueOf(optStack.pop().val)));
						}
					}
				
				}
			}
		}
		while(!optStack.isEmpty()){
			char c = optStack.pop().val;
			output.push(String.valueOf(c));
		}
		String x = "";
		while(!output.isEmpty()){
			x += output.pop();
		}
		return x;
	}
	
	private class Opt{
		char val;
		int priority;

		Opt(char val) {
			this.val = val;
			if ('(' == val || ')' == val) {
				priority = 0;
			}else if ('+' == val || '-' == val) {
				priority = 1;
			} else {
				priority = 2;
			}
		}
		
	}
	

}
