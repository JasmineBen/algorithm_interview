package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ
 * ����: "25525511135"
 * ���: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class ��ԭIP��ַ {
	
	public static void main(String[] args) {
		List<String> result = new ��ԭIP��ַ().restoreIpAddresses("0000");
		for(String s : result) {
			System.out.println(s);
		}
	}

	/**
	 * IP��ַ���4λ���12λ
	 */
	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() < 4 || s.length() > 12) {
			//�߽������ж�
			return new ArrayList<>();
		}
		return restoreIpAddresses(s,4);
	}
	
	private List<String> restoreIpAddresses(String leftStr,int leftCount) {
		List<String> result = new ArrayList<>();
		//�ݹ��˳�����
		if(leftCount == 0 && leftStr.length() == 0) {
			result.add("");
			return result;
		}
		/**
		 * leftStr�ı������leftCount
		 * leftCount*3����Ҫ���ڵ���leftStr�ĳ���
		 */
		if(leftCount > leftStr.length() || leftStr.length() > leftCount * 3) {
			return new ArrayList<>();
		}
		//�ֱ�ȡ��1,2,3λ
		for(int i=1;i<=Math.min(3,leftStr.length());i++) {
			String head = leftStr.substring(0, i);
			//IP��ÿһλ����С��256
			if(Integer.parseInt(head) > 255) {
				continue;
			}
			//IP��ÿ1λ������0xx
			if(head.length() > 1 && head.startsWith("0")) {
				continue;
			}
			String tail = leftStr.substring(i);
			List<String> subResult = restoreIpAddresses(tail, leftCount-1);
			if(subResult.size() > 0) {
				for(String s : subResult) {
					if(!s.isEmpty()) {
						result.add(head+"."+s);
					}else {
						result.add(head);
					}
				}
			}
		}
		return result;
	}
}
