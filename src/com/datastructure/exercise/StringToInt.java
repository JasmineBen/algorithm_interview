package com.datastructure.exercise;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 */
public class StringToInt {
	
	public static void main(String[] args) {
		System.out.println('9'-'0');
		System.out.println('9');
		StringToInt test = new StringToInt();
		System.out.println(test.StrToInt("+2147483647"));
	}

	public int StrToInt(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char[] chars = str.toCharArray();
		if (chars.length > 1) {
			char c0 = chars[0];
			if (c0 == '+' || c0 == '-') {
				int sum = compute(true, chars);
				if (c0 == '+') {
					return sum;
				} else {
					return -sum;
				}
			} else {
				return compute(false, chars);
			}
		}else if(isIllegleNum(chars[0])){
			return chars[0] - '0';
		}else{
			return 0;
		}
	}
	
	private int compute(boolean symbol,char[] chars){
		int sum = 0;
		int base = 1;
		int start = symbol ? 0 : -1;
		for(int i = chars.length - 1;i> start;i--){
			char c = chars[i];
			if(!isIllegleNum(c)){
				return 0;
			}else{
				sum += base * (c - '0');
				base *= 10;
			}
			
		}
		return sum;	
	}
	
	private boolean isIllegleNum(char c){
		return c>'0' && c < '9';
	}
}
