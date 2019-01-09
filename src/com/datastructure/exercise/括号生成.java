package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * ���磬���� n = 3�����ɽ��Ϊ��
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
   ]
 */
public class �������� {
	
	public static void main(String[] args) {
		System.out.println(new ��������().generateParenthesis(3));
	}

	/**
	 * ���ݷ�
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if(n > 0) {
			generate(result,"",n,n);
		}
		return result;
	}
	
	/**
	 * ���ݷ���
	 * 1��leftcount > 0 ʱ������������
	 * 2��rightcount > leftcountʱ������������
	 */
	private void generate(List<String> result,String str,int leftCount,int rightCount) {
		if(leftCount <= 0 && rightCount <= 0) {
			result.add(str);
		}
		if(leftCount > 0) {
			generate(result, str+"(", leftCount-1, rightCount);
		}
		if(leftCount < rightCount) {
			generate(result, str+")", leftCount, rightCount-1);
		}
	}
}
