package com.datastructure.exercise;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class 有效的括号 {
	
	public static void main(String[] args) {
		System.out.println(new 有效的括号().isValid("{}"));
	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() > 0 && s.length() % 2 == 0) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char currentChar = s.charAt(i);
				if (!stack.isEmpty()) {
					if ((stack.peek() == '(' && currentChar == ')') || (stack.peek() == '[' && currentChar == ']')
							|| (stack.peek() == '{' && currentChar == '}')) {
						stack.pop();
					} else {
						stack.push(currentChar);
					}
				} else {
					stack.push(currentChar);
				}
			}
			return stack.isEmpty();

		}
		return false;
	}
}
