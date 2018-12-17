package com.datastructure.exercise;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 *
 */
public class 倒序打印单词 {
	
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
