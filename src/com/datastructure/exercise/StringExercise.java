package com.datastructure.exercise;

import java.util.HashMap;

public class StringExercise {
	
	public static void main(String[] args) {
//		System.out.println(isDeformation("123", "231"));
//		System.out.println(isDeformation("123", "2331"));
//		System.out.println(numSum("A-1cd-2e--33"));
//		System.out.println(removeKZeros("A0000B000",4));
//		System.out.println(isRotation("1234", "3412"));
//		System.out.println(replace("123abcabca4", "abc", "x"));
		System.out.println(replaceSpace("I am a student.      ".toCharArray())+";");
	}

	/**
	 * 字符串a b的字符一样说明两者之间互为变形词，出现的字母一样，且每个字母的数量一致
	 * 例如：“123” “231”互为变形词, “123” "2331"不是变形词
	 * 用一个HashMap来计算，key为字符串的字符，value为字符出现的次数。
	 * 首先遍历a,将a中的字符插入HashMap中，并更新每个字符的数量，相同字符的数量加1.
	 * 然后遍历b，对b中的字符，如果HashMap中不存在，直接返回false,
	 * 如果存在，则对HashMap中对应字符的数量做减法操作，如果出现减法操作有数量小于0，返回false
	 */
	public static boolean isDeformation(String a,String b){
		if(a == null || b == null || (a.length() != b.length())){
			return false;
		}
		//key为char字符，value为count
		HashMap<Integer,Integer> map = new HashMap<>();
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		for(char c : aChar){
			Integer key = c-'0';
			Integer count = map.get(key);
			if(count != null){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key,1);
			}
		}
		for(char c : bChar){
			Integer key = c-'0';
			Integer count = map.get(key);
			if(count != null){
				map.put(key, count-1);
				if(count < 0){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 计算字符串中所有的数字子串的和，如果数字左边出现的“-”为奇数时表示负数，反之表示正数
	 * “A1cd2e33”  == 1+2+33 = 36
	 */
	public static int numSum(String s) {
		char[] chars = s.toCharArray();
		int res = 0;// 计算结果
		int num = 0;// 当前识别的数字子串
		boolean flag = true;// 正数标记
		for (int i = 0;i<chars.length;i++) {
			int code = chars[i] - '0';
			if (code < 0 || code > 9) {// 非数字
				res += num;
				num = 0;
				if (i-1>=0 && chars[i] == '-' && chars[i-1] == '-') {
					flag = !flag;
				}else{
					flag = false;
				}
			} else {// 数字
				num = num * 10 + (flag ? code : -code);
			}
		}
		res += num;
		return res;
	}
	
	/**
	 * 去掉字符串中连续的k个0
	 * 例如：“A00B”，k=2时返回AB
	 * “A0000B000”，k=3时返回A0000B
	 */
	public static String removeKZeros(String s, int k) {
		if (s == null || s.length() < k) {
			return s;
		}
		char[] chars = s.toCharArray();
		int count = 0;
		int start = -1;
		for(int i=0;i<chars.length;i++){
			int code = chars[i]-'0';
			if(code == 0){
				count ++;
				start = (start ==-1?i:start);
			}else{
				if(count == k){
					for(int j = start;j<start+k;j++){
						chars[j]=0;//替换成空格
					}
				}
				count = 0;
				start = -1;
			}
			
		}
		if(count == k){
			for(int j = start;j<start+k;j++){
				chars[j]=0;//替换成空格
			}
		}
		StringBuffer sb = new StringBuffer();
		for(char c : chars){
			if(c != 0){
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 判断a b是否互为旋转词,“1234”和“3412”互为旋转词
	 * 假设a为x、y两个子串组成，如果a b互为旋转词，那么b一定是y、x两个子串组成。
	 * 所以a+a=xyxy一定包含b
	 */
	public static boolean isRotation(String a,String b){
		if(a.length() != b.length()){
			return false;
		}
		return (a+a).contains(b);
	} 
	
	/**
	 * 将字符串str中连续出现的字符串from替换成字符串to.
	 * 例如str=“123abcabca4”,from="abc",to="x",替换完成后str=123xa4
	 * 思想：将str转为字符数组，将连续的from用0表示，转化后为['1','2','3',0,0,0,0,0,0,'a','4'],
	 * 然后再将字符数组中所有的非0进行组装
	 */
	public static String replace(String str,String from,String to){
		char[] strChars = str.toCharArray();
		char[] fromChars = from.toCharArray();
		int match = 0;
		for(int i = 0;i<strChars.length;i++){
			if(strChars[i] == fromChars[match]){
				match++;
				if(match == fromChars.length){//匹配一个成功
					while(match != 0){
						strChars[i-match+1] = 0;
						match--;
					}
					match = 0;
				}
			}else{
				if(strChars[i]==fromChars[0]){
					i--;
				}
				match = 0;
			}
			
		}
	
		StringBuffer sb = new StringBuffer();
		String cur = "";
		for(int i = 0;i<strChars.length;i++){
			if(strChars[i] != 0){
				cur = cur+String.valueOf(strChars[i]);
			}
			if(strChars[i] == 0 && (i ==0||strChars[i-1] != 0)){//当前字符为0，且前一个字符不为0，可以进行替换
				sb.append(cur).append(to);
				cur = "";
			}
		}
		if(!cur.equals("")){
			sb.append(cur);
		}
		return sb.toString();
	}
	
	/**
	 * 一个字符串以.结尾，将字符数组中的空格替换成 %20
	 * 假设输入字符数组后面有大量空闲位置(important)
	 * 1、先计算原数组中有多少空格字符
	 * 2、假设原字符数组中的字符数量为x，有y个空格符，那么在替换完成后字符数量为x+2*y
	 */
	public static String replaceSpace(char[] strs){
		int spaceCount = 0;//空格数量
		int beforeLen = 0;//替换前的有效字符数量
		int afterLen = 0;//替换后的有效字符数量
		for(int i = 0;i<strs.length;i++){
			if(strs[i] == ' '){
				spaceCount++;
			}
			beforeLen ++;
			if(strs[i] == '.'){
				break;
			}	
		}
		if(spaceCount > 0){
			afterLen = beforeLen + 2 * spaceCount;
			afterLen--;
			for(int i=beforeLen-1;i>=0;i--){
				if(strs[i] != ' '){
					strs[afterLen--] = strs[i];
				}else{
					strs[afterLen--] = '0';
					strs[afterLen--] = '2';
					strs[afterLen--] = '%';
				}
			}
		}
		
		return new String(strs);
	}
}
