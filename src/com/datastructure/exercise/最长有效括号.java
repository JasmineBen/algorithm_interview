package com.datastructure.exercise;

import java.util.Stack;

/**
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
 * ʾ�� 1:
 * ����: "(()"
 * ���: 2
 * ����: ���Ч�����Ӵ�Ϊ "()"
 * ʾ�� 2:
 * ����: ")()())"
 * ���: 4
 * ����: ���Ч�����Ӵ�Ϊ "()()"
 *
 */
public class ���Ч���� {
	
	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(new ���Ч����().longestValidParentheses(s));
	}

	//stack����
	public int longestValidParentheses(String s) {
		int max = 0;
		if(s != null && s.length() > 0) {
			char[] chars = s.toCharArray();
			int start = 0;//��Ч���ŶԵĿ�ʼλ��
			Stack<Integer> stack = new Stack<>();
			for(int i = 0;i<chars.length;i++) {
				if('(' == chars[i]) {
					stack.push(i);//��¼�����ŵ�λ��
				}else {
					if(stack.isEmpty()) {
						//���������ţ������û���������ţ�˵��ǰ����ַ��������Ϲ淶
						start = i + 1;
					}else {
						//���������ţ�����������ƥ�䣬��ô�������ŵ�����
						stack.pop();
						//�жϵ������Ƿ�����������
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
