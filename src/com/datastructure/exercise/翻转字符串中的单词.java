package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 * ����: "the sky is blue",
 * ���: "blue is sky the".
 * 
 * �޿ո��ַ�����һ�����ʡ�
 * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 */
public class ��ת�ַ����еĵ��� {
	
	public static void main(String[] args) {
		reverseWords("a b a");
	}

	/**
	 * 1��ȥ����β�Ŀո�
	 * 2��ѭ�����ַ������ҵ���һ���ո񣬲����ո�֮ǰ�ĵ��ʴ浽���飬ͬʱ����flag
	 * 3������ �������������ǿ��ַ�ʱ������һ��subString��λ��nextStart��������flag
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		if(s.trim().length() == 0) {
			return "";
		}
		s = s.trim();//ȥ��ǰ��ͺ�����ַ���
		List<String> list = new ArrayList<>();
		boolean flag = false;
		int nextStart = 0;
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == ' ') {
				if(flag) {
					list.add(s.substring(nextStart, i));
					flag = false;
				}
			}else {
				if(!flag) {
					nextStart = i;
					flag = true;
				}
			}
		}
		list.add(s.substring(nextStart, s.length()));
		StringBuilder sb = new StringBuilder();
		for(int i = list.size()-1;i>=0;i--) {
			if(i == 0) {
				sb.append(list.get(i));
			}else {
				sb.append(list.get(i)).append(" ");
			}
		}
		System.out.println(sb.toString()+";");
		return sb.toString();
	}
}
