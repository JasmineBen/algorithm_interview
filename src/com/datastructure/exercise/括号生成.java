package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
   ]
 */
public class 括号生成 {
	
	public static void main(String[] args) {
		System.out.println(new 括号生成().generateParenthesis(3));
	}

	/**
	 * 回溯法
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if(n > 0) {
			generate(result,"",n,n);
		}
		return result;
	}
	
	/**
	 * 回溯法：
	 * 1、leftcount > 0 时，输入左括号
	 * 2、rightcount > leftcount时，输入右括号
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
