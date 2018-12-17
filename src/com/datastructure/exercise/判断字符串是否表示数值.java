package com.datastructure.exercise;

/**
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *  ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 *
 */
public class �ж��ַ����Ƿ��ʾ��ֵ {
	
	public static void main(String[] args) {
		String pattern = "[\\+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?)";
		String str = "100";
		System.out.println(str.matches(pattern));
		System.out.println(str.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?"));;
	}

	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		String input = new String(str);
		String pattern = "[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?";
		return input.matches(pattern);
	}
}
