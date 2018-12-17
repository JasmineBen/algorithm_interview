package com.datastructure.exercise;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ��� ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"
 *
 */
public class ��һ��ֻ����һ�ε��ַ� {

	public static void main(String[] args) {
		String s = "google";
		System.out.println(firstAppearingOnce(s));
	}
	// �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
	public static char firstAppearingOnce(String s) {
		char[] chars = s.toCharArray();
		// charռ8λ��������һ��256�������ʾ
		int[] input = new int[256];
		for(char c : chars){
			if(input[c] == 0){
				input[c] = 1;
			}else{
				input[c] += 1;
			}
		}
		for (char c : chars) {
			if (input[c] == 1) {
				return c;
			}
		}
		return '#';
	}
}
