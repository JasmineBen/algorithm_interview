package com.datastructure.exercise;

/**
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * ʾ�� 1:
 * �������� nums = [1,1,2], 
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 */
public class ɾ�����������е��ظ��� {
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3};
		System.out.println(new ɾ�����������е��ظ���().removeDuplicates(nums));
		for(int i : nums) {
			System.out.println(i);
		}
	
	}

	/**
	 * ˫ָ��ⷨ
	 */
	public int removeDuplicates(int[] nums) {
		if (nums != null) {
			int i = 0;
			for(int j = 1;j<nums.length;j++) {
				if(nums[j] != nums[i]) {
					i++;
					nums[i] = nums[j];
				}
			}
			return i+1;
		}
		return 0;
	}
	
}
