package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ���ĵ� (Unix-style) ����ȫ·���������·����
 * ���磬
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * �߽����:
 * ���Ƿ����� ·�� = "/../" �������
 * ����������£����践�� "/" ��
 * ���⣬·����Ҳ���ܰ������б�� '/' ���� "/home//foo/" ��
 * ����������£���ɺ��Զ����б�ܣ����� "/home/foo" ��
 */
public class ��·�� {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
	}
	
	/**
	 * ����"."��ʾ��ǰ·����".."��ʾ��һ��·��
	 * �м���"."�����ֱ��ȥ������".."ʱɾ�������氤�ŵ�һ��·��
	 * ����Ƕ��"/"������һ��;����ǿ��򷵻�"/"
	 * 
	 * 1��ͨ��String.split("/")���ַ����ָ�
	 * 2��
	 */
	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "/";
		}
		String[] splits = path.split("/");
		Stack<String> stack = new Stack<>();
		/**
		 * �����зǿգ���"."���ַ���ѹ��ջ
		 * /home/of/foo/../../bar/../../is/./here/.  ��Ӧջ���������£�
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
