package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 * ˵�����⼯���ܰ����ظ����Ӽ���
 * ʾ��:
 * ����: nums = [1,2,3]
 * ���:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
public class ���������е��Ӽ� {

	public static void main(String[] args) {
		int nums[] = {1,3,2,3};
		List<List<Integer>> result = new ���������е��Ӽ�().subsets(nums);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums != null && nums.length > 0) {
			sort(nums);//������
			List<Integer> subset = new ArrayList<>();
			subset(result,subset,nums,0);
		}
		return result;
	}
	
	private void subset(List<List<Integer>> result, List<Integer> subset, int[] nums,int beg) {
		System.out.println(subset);
		List<Integer> temp = new ArrayList<>(subset);
		result.add(temp);
		for(int i = beg;i<nums.length;i++) {
			//������ͬ��Ԫ��
			while(i+1<nums.length && nums[i] == nums[i+1]) {
				i++;
			}
			subset.add(nums[i]);
			subset(result,subset,nums,i+1);
			//��һ������Ҫ,��֤
			subset.remove(subset.size()-1);
		}
	}
	
	private void sort(int[] nums) {
		for(int i = 0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
}
