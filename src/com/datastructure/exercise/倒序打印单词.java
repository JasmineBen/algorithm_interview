package com.datastructure.exercise;

/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��
 * дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
 * ��ȴ������������˼�����磬��student. a am I������������ʶ����
 * ��һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����
 *
 */
public class �����ӡ���� {
	
	public static void main(String[] args) {
		String s = "student. a am I";
		System.out.println(ReverseSentence(s));
	}
	public static String ReverseSentence(String str) {
		if(str == null || str.isEmpty()){
			return "";
		}
		String result = "";
		String temp = "";
		char[] chars = str.toCharArray();
		for(char c : chars){
			if(c == ' '){
				result = " " + temp + result;
				temp = "";
			}else{
				temp += String.valueOf(c);
			}
		}
		if(!temp.isEmpty()){
			result = temp + result;
		}
		return result;
	}
}
