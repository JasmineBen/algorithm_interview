package com.datastructure.exercise;

import java.util.Stack;

/**
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 * �ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 * ʾ�� 1:
 * ����: "()"
 * ���: true
 * ʾ�� 2:
 * ����: "()[]{}"
 * ���: true
 * ʾ�� 3:
 * ����: "(]"
 * ���: false
 * ʾ�� 4:
 * ����: "([)]"
 * ���: false
 * ʾ�� 5:
 * ����: "{[]}"
 * ���: true
 *
 */
public class ��Ч������ {
	
	public static void main(String[] args) {
		System.out.println(new ��Ч������().isValid("{}"));
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
