package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
public class PrintMinNumber {
	
	public static void main(String[] args) {
		int[] nums = new int[]{321,3,44,32};
		PrintMinNumber test = new PrintMinNumber();
		System.out.println(test.PrintMinNumber(nums));
	}

	/*
	 * ��ab > ba �� a > b��
	 * ��ab < ba �� a < b��
	 * ��ab = ba �� a = b��
	 *
	 * ��֮������
	 */
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		List<String> source = new ArrayList<String>();
		for(int num : numbers){
			source.add(String.valueOf(num));
		}
		//��string����ƴ�Ӻ�Ĵ�С����
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
