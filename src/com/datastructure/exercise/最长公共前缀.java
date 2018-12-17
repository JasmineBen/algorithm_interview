package com.datastructure.exercise;

/**
 * ��дһ�������������ַ��������е������ǰ׺����������ڹ���ǰ׺�����ؿ��ַ��� "" 
 * ����: ["flower","flow","flight"] ���:"fl"
 */
public class �����ǰ׺ {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}

	/**
	 * ���ö��ַ�
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null) {
			return "";
		}
		
		return longestCommonPrefix(strs,0,strs.length-1);
	}
	
	
	private static String longestCommonPrefix(String[] strs,int start,int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			String first = longestCommonPrefix(strs,start,mid);
			String second = longestCommonPrefix(strs,mid+1,end);
			return longestCommonPrefix(first,second);
		}else if(start == end) {
			return strs[start];
		}
		return "";
	}
	
	private static String longestCommonPrefix(String first,String second) {
		int len = Math.min(first.length(), second.length());
		int i = 0;
		for(i = 0;i<len;i++) {
			if(first.charAt(i) != second.charAt(i)) {
				break;
			}
		}
		if(i == 0) {
			return "";
		}
		return first.substring(0, i);
	} 
	
}
