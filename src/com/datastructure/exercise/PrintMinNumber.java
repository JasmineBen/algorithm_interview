package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
	
	public static void main(String[] args) {
		int[] nums = new int[]{321,3,44,32};
		PrintMinNumber test = new PrintMinNumber();
		System.out.println(test.PrintMinNumber(nums));
	}

	/*
	 * 若ab > ba 则 a > b，
	 * 若ab < ba 则 a < b，
	 * 若ab = ba 则 a = b；
	 *
	 * 反之不成立
	 */
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		List<String> source = new ArrayList<String>();
		for(int num : numbers){
			source.add(String.valueOf(num));
		}
		//将string按照拼接后的大小排列
		Collections.sort(source,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(String s : source){
			sb.append(s);
		}
		return sb.toString();
	}
	
}
