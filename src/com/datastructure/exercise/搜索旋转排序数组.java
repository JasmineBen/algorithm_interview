package com.datastructure.exercise;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
 * ����Լ��������в������ظ���Ԫ�ء�
 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
 */
public class ������ת�������� {
	
	public static void main(String[] args) {
		int[] a = {1};
		System.out.println(new ������ת��������().search(a,1));
	}

	/**
	 * �����������ת�϶���ĳ���ڵ�iʹ��nums[i...n]<num[0,i-1],����[0,i-1]��nums[i,n]���������
	 * Ҫ���Ӷ���O(log n)���϶����ܴ�ͷ��β��˳������
	 * log n��������ȣ��϶���Ҫ�������Ϊ���������⣬����ʹ�����ƶ��ֵķ�ʽ����
	 *
	 */
	public int search(int[] nums, int target) {
		if (nums != null) {
			int low = 0;
			int high = nums.length - 1;
			while (low <= high) {
				if (nums[low] == target) {
					return low;
				}
				if (nums[high] == target) {
					return high;
				}
				if (nums[low] > target && nums[high] < target) {
					return -1;
				}
				int middle = (low + high) / 2;
				if(nums[middle] == target) {
					return middle;
				}else if (nums[low] < nums[middle]) {
					// ��ߵ������ǵ����ģ��ұ߿�������תҲ�����ǵ���
					if (target < nums[middle] && target >= nums[low]) {
						//��ߵ����������ֻ��nums[start]<=target<=nums[middle]ʱ�������߲�ѯ
						high = middle - 1;
					} else {
						//�������ұ߲�ѯ
						low = middle + 1;
					}
				} else {
					//�������ת�ģ��ұ߿϶��ǵ�����
					if (target > nums[middle] && target <= nums[high]) {
						low = middle + 1;
					} else {
						high = middle - 1;
					}
				}
			}
		}
		return -1;
	}

}
