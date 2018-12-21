package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 *[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 *]	
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 要求空间复杂度 O(n)
 */
public class 三角形最小路径和 {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		triangle.add(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		triangle.add(list2);
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		triangle.add(list3);
		List<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list4);
		System.out.println(new 三角形最小路径和().minimumTotal(triangle));
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle != null && triangle.size() > 0) {
			//动态规划解法，从底向上更新上一个列表的最短路径
			List<Integer> nextList = triangle.get(triangle.size()-1);
			for(int i = triangle.size()-2;i>=0;i--) {
				List<Integer> currentList = triangle.get(i);
				List<Integer> newList = new ArrayList<>();
				for(int j = 0;j<currentList.size();j++) {
					newList.add(Math.min(nextList.get(j)+currentList.get(j),nextList.get(j+1)+currentList.get(j)));
				}
				nextList = newList;
			}
			return nextList.get(0);
		}
		return 0;
	}
	
	
	
	/**
	 * 递归解法
	 */
	private int minimumTotal(List<List<Integer>> triangle,int nextLine,int i) {
		if(nextLine < triangle.size()) {
			int a = minimumTotal(triangle,nextLine+1,i);
			int b = minimumTotal(triangle, nextLine+1, i+1);
			return Math.min(triangle.get(nextLine).get(i)+a, triangle.get(nextLine).get(i+1)+b);
		}
		return 0;
	}
}
