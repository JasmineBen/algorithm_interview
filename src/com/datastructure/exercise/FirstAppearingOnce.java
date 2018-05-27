package com.datastructure.exercise;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 *
 */
public class FirstAppearingOnce {
	
	private int[] input = new int[256];
	private String s = new String();
	//char占8位，可以用一个256的数组表示
	 public void Insert(char ch){
	    s += ch;
	    if(input[ch] == 0){
	    	input[ch] = 1;// 第一次插入
	    }else{// 多次插入
	    	input[ch] += 1;
	    }
	 }

	//如果当前字符流没有存在出现一次的字符，返回#字符。
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
