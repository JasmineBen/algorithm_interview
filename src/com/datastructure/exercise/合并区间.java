package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。 输入: [[1,3],[2,6],[8,10],[15,18]] 输出:
 * [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 */
public class 合并区间 {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 1));
		List<Interval> results = new 合并区间().merge(intervals);
//		for (Interval interval : results) {
//			System.out.println(interval);
//		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals != null) {
			int size = intervals.size();
			//最多需要循环intervals.size()次
			for (int index = 0; index < size; index++) {
				if (intervals.size() > 0) {
					Interval removed = intervals.remove(0);
					//查询removed同一区间的元素
					for (int i = intervals.size() - 1; i >= 0; i--) {
						Interval elected = intervals.get(i);
						if (removed.start <= elected.start 
								&& (removed.end >= elected.start || removed.end >= elected.end)) {
							Interval item = new Interval(removed.start, Math.max(removed.end,elected.end));
							removed = item;
							System.out.println(removed);
							intervals.remove(i);
						} else if (elected.start <= removed.start 
								&& (elected.end >= removed.start || elected.end >= removed.end )) {
							Interval item = new Interval(elected.start, Math.max(removed.end,elected.end));
							removed = item;
							intervals.remove(i);
						}
					}
					intervals.add(removed);
				}else {
					break;
				}
			}
		}
		return intervals;
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}
}
