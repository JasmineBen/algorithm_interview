package com.datastructure.exercise;

/**
 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
 * ʾ�� 1:
 * ����: [1,2,0]
 * ���: 3
 * ʾ�� 2:
 * ����: [3,4,-1,1]
 * ���: 2
 * ʾ�� 3:
 * ����: [7,8,9,11,12]
 * ���: 1
 *
 */
public class ȱʧ�ĵ�һ������ {
	
	public static void main(String[] args) {
		int[] nums = {-1,4,2,1,9,10};
		System.out.println(new ȱʧ�ĵ�һ������().firstMissingPositive(nums));
	}

	//�ѵ�ǰ���ŵ��÷ŵ�λ�ü��ɣ���1Ӧ�÷ŵ���0��λ�ã�2Ӧ�÷ŵ���1��λ��
	public int firstMissingPositive(int[] nums) {
		if(nums != null) {
			for(int i = 0;i<nums.length;) {
				if(nums[i] == i+1) {
					i++;
				}else {
					//nums[i]Ӧ�÷ŵ�nums[i]-1��λ��
					if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
						int temp = nums[nums[i]-1];
						nums[nums[i]-1] = nums[i];
						nums[i] = temp;
						//������֮����Ҫ�����ж�i��λ��ֵ
					}else {
						i++;
					}
				}
			}
			for(int i = 0;i<nums.length;i++) {
				if(nums[i] != i+1) {
					return i+1;
				}
			}
			return nums.length + 1;
		}
		return 1;
	}
}
