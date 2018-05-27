package com.datastructure.basic;

import java.util.Stack;

/**
 * 表达式
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
	 * 将输入表达式转化为前序，然后再计算
	 * 即从右至左取数，直到取出一个运算符，将刚取出的紧挨着运算符的两个操作数按运算符进行计算，
	 * 结果回填至运算符。重复该步骤，直到最后只剩下一个字符串则剩下的字符串即为结果
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
				// 操作数直接压入
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
	 * 当有了后缀表达式以后，运算表达式的值就非常容易了。可以按照下面的流程来计算。
	 * （1）从左向右扫描表达式，一个取出一个数据data
	 * （2）如果data是操作数，就压入堆栈
	 * （3）如果data是操作符，就从堆栈中弹出此操作符需要用到的数据的个数，进行运算，然后把结果压入堆栈
	 * （4）如果数据处理完毕，堆栈中最后剩余的数据就是最终结果。
	 */
	private int computePostOrderExpression(String input) {
		String postOrder = postOrder(input);
		System.out.println(postOrder);
		char[] chars = postOrder.toCharArray();
		Stack<Integer> dataStack = new Stack<>();
		for(char c : chars){
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {
				// 操作数直接压入
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
	 * 中缀表达式翻译成后缀表达式的方法如下：
	 * （1）从左向右依次取得数据ch。
	 * （2）如果ch是操作数，直接输出。
	 * （3）如果ch是运算符（含左右括号），则：
	 *      a：如果ch = '('，放入堆栈。
	 * 	    b：如果ch = ')'，依次输出堆栈中的运算符，直到遇到'('为止。
	 *      c：如果ch不是')'或者'('，那么就和堆栈顶点位置的运算符top做优先级比较。
	 *         1：如果ch优先级比top高，那么将ch放入堆栈。
	 *         2：如果ch优先级低于或者等于top，那么输出top，然后将ch放入堆栈。
	 * （4）如果表达式已经读取完成，而堆栈中还有运算符时，依次由顶端输出。
	 */
	private String postOrder(String input) {
		char[] chars = input.toCharArray();
		Stack<Opt> optStack = new Stack<>();
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {
				// 操作数直接输出
				output.append(String.valueOf(c));
			} else {// 操作符
				Opt opt = new Opt(c);
				if (c == '(') {// 左括号直接压入堆栈
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
	 * 1、反转输入字符串，如“2*3/(2-1)+3*(4-1)” 反转后为“ )1-4(*3+)1-2(/3*2”，
	 * 2、从字符串中取出下一个字符
　　			2.1.如果是操作数，则直接输出
　　			2.2.如果是“)”，压入栈中
　　			2.3.如果是运算符但不是“(”，“)”,则不断循环进行以下处理
　　　　			2.3.1.如果栈为空，则此运算符进栈，结束此步骤
　　　　			2.3.2.如果栈顶是“)”,则此运算符进栈，结束此步骤
　　　　			2.3.2.如果此运算符与栈顶优先级相同或者更高，此运算符进栈，结束此步骤
　　　　			2.3.4.否则，运算符连续出栈输出，直到满足上述三个条件之一，然后此运算符进栈
　　			2.4、如果是“(”，则运算符连续出栈输出，直到遇见“)”为止,将“)”出栈且丢弃之
	  3、如果还有更多的字符串，则转到第2步
      4、不在有未处理的字符串了，输出栈中剩余元素
      5、再次反转字符串得到最终结果
	 */
	private String preOrder(String input){
		Stack<String> output = new Stack<>();
		Stack<Opt> optStack = new Stack<>();
		char[] chars = input.toCharArray();
		for(int i = chars.length -1;i>=0;i--){
			char c = chars[i];
			if (c != '+' && c != '-' && c != '*' && c != '/' 
					&& c != '(' && c != ')') {//2.1
				// 操作数直接输出
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
