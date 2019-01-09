package com.datastructure.exercise;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class 最长有效括号 {
	
	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(new 最长有效括号().longestValidParentheses(s));
	}

	//stack方案
	public int longestValidParentheses(String s) {
		int max = 0;
		if(s != null && s.length() > 0) {
			char[] chars = s.toCharArray();
			int start = 0;//有效括号对的开始位置
			Stack<Integer> stack = new Stack<>();
			for(int i = 0;i<chars.length;i++) {
				if('(' == chars[i]) {
					stack.push(i);//记录左括号的位置
				}else {
					if(stack.isEmpty()) {
						//遇到右括号，如果还没出现左括号，说明前面的字符都不符合规范
						start = i + 1;
					}else {
						//遇到右括号，且有左括号匹配，那么将左括号弹出来
						stack.pop();
						//判断弹出后是否还有左括号了
						if(stack.isEmpty()) {
							max = Math.max(max, i-start+1);
						}else {
							max = Math.max(max, i-stack.peek());
						}
					}
				}
			}
		}
		return max;
	}
}
