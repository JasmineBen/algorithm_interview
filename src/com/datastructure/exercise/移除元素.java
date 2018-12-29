package com.datastructure.exercise;

/**
 * ����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ�� 1:
 * ���� nums = [3,2,2,3], val = 3,
 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 */
public class �Ƴ�Ԫ�� {

	/**
	 * ˫ָ�뷨
	 */
	public int removeNums(int[] nums,int val) {
		if(nums != null && nums.length > 0) {
			int i = 0;//ʼ�ռ�¼nums[i] = val����
			for(int j = 0;j<nums.length;j++) {
				if(nums[j] != val) {
					nums[i] = nums[j]; 
					i++;
				}
				return i;
			}
		}
		return 0;
	}
}
