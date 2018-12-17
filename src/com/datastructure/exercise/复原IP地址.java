package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class 复原IP地址 {
	
	public static void main(String[] args) {
		List<String> result = new 复原IP地址().restoreIpAddresses("0000");
		for(String s : result) {
			System.out.println(s);
		}
	}

	/**
	 * IP地址最短4位，最长12位
	 */
	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() < 4 || s.length() > 12) {
			//边界条件判断
			return new ArrayList<>();
		}
		return restoreIpAddresses(s,4);
	}
	
	private List<String> restoreIpAddresses(String leftStr,int leftCount) {
		List<String> result = new ArrayList<>();
		//递归退出条件
		if(leftCount == 0 && leftStr.length() == 0) {
			result.add("");
			return result;
		}
		/**
		 * leftStr的必须大于leftCount
		 * leftCount*3必须要大于等于leftStr的长度
		 */
		if(leftCount > leftStr.length() || leftStr.length() > leftCount * 3) {
			return new ArrayList<>();
		}
		//分别取第1,2,3位
		for(int i=1;i<=Math.min(3,leftStr.length());i++) {
			String head = leftStr.substring(0, i);
			//IP的每一位必须小于256
			if(Integer.parseInt(head) > 255) {
				continue;
			}
			//IP的每1位不能是0xx
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
