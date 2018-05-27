package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
 * ���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *  {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 *  {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *
 */
public class MaxInWindows {
	
	public static void main(String[] args) {
		int num[] = new int[]{2,3,4,2,6,2,5,1};
		MaxInWindows test = new MaxInWindows();
		ArrayList<Integer> result = test.maxInWindows(num, 0);
		for(int i : result){
			System.out.println(i);
		}
	}
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num != null && num.length >= size && size>0) {
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size,new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			for(int i = 0;i< num.length - size + 1;i++){
				for(int j = i;j<size+i;j++){
					queue.offer(num[j]);
				}
				result.add(queue.poll());
				queue.clear();
			}
		}
		return result;
	}
	
}
