package com.datastructure.exercise;

/**
 * ����һ��δ��������������飬�ҵ���������ĵĵ������С�
 * ����: [1,3,5,4,7]
 *���: 3
 *����: ��������������� [1,3,5], ����Ϊ3��
 *���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ5��7��ԭ�����ﱻ4������ 
 */
public class ��������������� {

	
	/**
	 * ������nums[i]��β��������������������Ϊdp[i],����
	 * dp[i+1]=dp[i]+1  (nums[i+1]>nums[i])
	 * dp[i+1]=1 (nums[i+1]<=nums[i])
	 */
	 public int findLengthOfLCIS(int[] nums) {
		 if(nums != null && nums.length > 0) {
			 int[] dp = new int[nums.length];
			 dp[0] = 1;
			 for(int i = 1;i < nums.length;i++) {
				 if(nums[i] > nums[i-1]) {
					 dp[i] = dp[i-1]+1;
				 }else {
					 dp[i] = 1;
				 }
			 }
			 int max = dp[0];
			 for(int i = 1;i<dp.length;i++) {
				 if(max < dp[i]) {
					 max = dp[i];
				 }
			 }
			 return max;
		 }
		 return 0;
	 }
}
