package com.datastructure.exercise;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 * ʾ��:
 * ����: [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 * ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 *
 */
public class ��Ծ��Ϸ2 {
	
	private int minStep = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new ��Ծ��Ϸ2().jump(nums));
	}

	/**
	 * ����ĳһ���ķ�Χ��
	 * cur��pre�ֱ������浱ǰ���ܵ������Զλ�ú�֮ǰ�ܵ������Զλ��
	 */
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int result = 0;
		int cur = 0;//��ǰ�ܵ������Զ����
		while (cur < nums.length - 1) {//��ǰ�ܹ���������ĩ�ˣ��˳�ѭ��
			result++;//��һ�������ܵ���ķ�Χ��
			int pre = cur;//֮ǰ�ܵ������Զ����
			for (int i = 0; i <= pre; i++) {
				//i+nums[i]��ʾi�ڵ��ܵ���������룬i��ʾ��һ���ܹ�����Ľڵ㣬
				//��һ���ܹ�����Ľڵ���ϵ�ǰ�ڵ��ܹ����Ĳ��������ܵõ���ǰ�ڵ���һ���ķ�Χ,
				//cur������Щ�ڵ��ܹ����ﷶΧ�����ֵ
				cur = Math.max(cur, i + nums[i]);
			}
			if (pre == cur) {
				return -1;
			}
		}
		return result;
	}
	
	//�ݹ�ⷨ��̫�����ʱ��
	private int jump(int[] nums, int index, int step) {
		if (index >= nums.length-1) {
			return step;
		}
		for (int j = 1; j <= nums[index]; j++) {
			minStep = Math.min(jump(nums,index+j,step+1),minStep);
		}
		return Integer.MAX_VALUE;
	}
}
