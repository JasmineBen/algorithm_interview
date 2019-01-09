package com.datastructure.exercise;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * ���Ŀ������Ծ������������һ��λ�á�
 * ʾ��:
 * ����: [2,3,1,1,4]
 * ���: true
 * ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 *
 */
public class ��Ծ��Ϸ {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new ��Ծ��Ϸ().canJump(nums));
	}
	/**
	 * ��̬�滮
	 * dp[i]��ʾ����iλ��ʣ��Ĳ�����dp[0]=0,���У�
	 * dp[i] = max(dp[i-1],nums[i-1]) - 1;
	 * ����{2,3,1,1,4}��dp[0]=0,dp[1]=1,��ʾnums[0]����nums[1]ʣ��1����nums[0]=2,������nums[1]��Ҫ1������ʣ��2-1=1��
	 * ͬ��nums[1]����nums[2]ʣ��2����dp[2]=2,nums[1]=3,max(nums[1],dp[1])-1=2��
	 * ���dp[i] < 0˵��ʣ�ಽ�������ˣ��������յ���
	 */
	public boolean canJump(int[] nums) {
		if (nums != null && nums.length > 0) {
			int[] dp = new int[nums.length];
			dp[0] = 0;
			for (int i = 1; i < nums.length; i++) {
				dp[i] = Math.max(dp[i-1], nums[i-1])-1;
				if(dp[i] < 0) {
					//�޷����ﵱǰλ��
					return false;
				}
			}
		}
		return true;
	}
}
