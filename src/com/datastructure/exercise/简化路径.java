package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 边界情况:
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
public class 简化路径 {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
	}
	
	/**
	 * 解析"."表示当前路径，".."表示上一级路径
	 * 中间是"."的情况直接去掉，是".."时删掉它上面挨着的一个路径
	 * 如果是多个"/"，则保留一个;如果是空则返回"/"
	 * 
	 * 1、通过String.split("/")将字符串分割
	 * 2、
	 */
	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "/";
		}
		String[] splits = path.split("/");
		Stack<String> stack = new Stack<>();
		/**
		 * 将所有非空，非"."的字符串压如栈
		 * /home/of/foo/../../bar/../../is/./here/.  对应栈中内容如下：
		 *home of foo .. .. bar .. .. is here
		 */
		for(String s : splits) {
			if(s != null && s.length() != 0 && !".".equals(s)) {
				stack.push(s);
			}
		}
	
		Stack<String> resultStack = new Stack<>();
		int count = 0;
		while(!stack.isEmpty()) {
			if("..".equals(stack.peek())) {
				while(!stack.isEmpty() && "..".equals(stack.peek())) {
					count ++;
					stack.pop();
				}
				while(!stack.isEmpty() && count > 0 && !"..".equals(stack.peek())) {
					stack.pop();
					count--;
				}
			}else {
				if(count == 0) {
					resultStack.push(stack.pop());
				}else {
					stack.pop();
					count--;
				}
			}
			
		}
		if(resultStack.isEmpty()) {
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		while(!resultStack.isEmpty()) {
			sb.append("/").append(resultStack.pop());
		}
		
		return sb.toString();
	}
}
