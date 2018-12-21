package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ļ��ϣ���ϲ������ص������䡣 ����: [[1,3],[2,6],[8,10],[15,18]] ���:
 * [[1,6],[8,10],[15,18]] ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 *
 */
public class �ϲ����� {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 1));
		List<Interval> results = new �ϲ�����().merge(intervals);
//		for (Interval interval : results) {
//			System.out.println(interval);
//		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals != null) {
			int size = intervals.size();
			//�����Ҫѭ��intervals.size()��
			for (int index = 0; index < size; index++) {
				if (intervals.size() > 0) {
					Interval removed = intervals.remove(0);
					//��ѯremovedͬһ�����Ԫ��
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
