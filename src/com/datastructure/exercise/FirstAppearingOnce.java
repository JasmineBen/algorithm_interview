package com.datastructure.exercise;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"
 *
 */
public class FirstAppearingOnce {
	
	private int[] input = new int[256];
	private String s = new String();
	//charռ8λ��������һ��256�������ʾ
	 public void Insert(char ch){
	    s += ch;
	    if(input[ch] == 0){
	    	input[ch] = 1;// ��һ�β���
	    }else{// ��β���
	    	input[ch] += 1;
	    }
	 }

	//�����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
	public char FirstAppearingOnce(){
		char[] chars = s.toCharArray();
		for(char c : chars){
			if(input[c] == 1){
				return c;
			}
		}
		return '#';
    }
}
