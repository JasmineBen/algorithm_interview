package com.datastructure.exercise;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
 * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 *
 */
public class ѭ�������ַ��� {

	public String LeftRotateString(String str, int n) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		int length = str.length();
		int rotate = n % length;
		if(rotate == 0){
			return str;
		}else{
			String startStr = str.substring(0, rotate);
			return str.substring(rotate)+startStr;
		}
	}
}
