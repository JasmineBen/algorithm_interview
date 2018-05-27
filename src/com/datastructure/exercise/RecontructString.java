package com.datastructure.exercise;

/**
 * 字符串重组 输入：****a*b*c*.....输出：*******abc.....
 * 将所有的*都移动到字符串的前半部分，字符移动到后半部分，保证字符的顺序。
 *
 */
public class RecontructString {

	public static void main(String[] args) {
		String input = new String("****a*b*c.....*");
		System.out.println(recontruct(input));
	}

	public static String recontruct(String input) {
		char[] chars = input.toCharArray();
		int length = chars.length;
		int lastStar = length - 1;
		int lastNonStar =length - 1;
		for (int i = lastStar; i >= 0; i--) {
			if (chars[i] == '*') {// 找到最后一个*
				lastStar = i;
				break;
			}
		}
		while (lastStar > 0) {
			for (int i = lastStar - 1; i >= 0; i--) {
				if (chars[i] != '*') {// 找到最后一个非*
					lastNonStar = i;
					break;
				}
			}
			System.out.println("lastStar:"+lastStar+";lastNonStar:"+lastNonStar);
			if (lastNonStar < lastStar) {
				char cTemp = chars[lastNonStar];
				chars[lastNonStar] = chars[lastStar];
				chars[lastStar] = cTemp;
				if(lastStar-lastNonStar==1){
					lastStar = lastNonStar;
				}else{
					lastStar = lastNonStar + 1;
				}
			}else{
				break;
			}
		}
		return new String(chars);
	}
}
