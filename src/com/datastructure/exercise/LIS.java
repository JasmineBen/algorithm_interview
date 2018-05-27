package com.datastructure.exercise;

/**
 * 最长递增子序列（LIS）
 * 求一个一维数组arr[i]中的最长递增子序列的长度，如在序列1，-1，2，-3，4，-5，6，-7中，
 * 最长递增子序列长度为4，可以是1，2，4，6，也可以是-1，2，4，6。
 */
public class LIS {
	
	private int[] dp;
	private int lis = 1;
	
	public static void main(String[] args) {
		int[] a = new int[]{1,-1,2,-3,4,-5,6,-7};
		LIS test = new LIS();
		test.lis(a);
		//System.out.println(test.lis);
		test.print(a, a.length);
	}

	/**
	 * 第i个元素之前的最长递增子序列的长度要么是1（单独成一个序列），
	 * 要么就是第i-1个元素之前的最长递增子序列加1，可以有状态方程：
	 * LIS[i] = max{1,LIS[k]+1}，其中，
	 * 对于任意的k<=i-1，arr[i] > arr[k]，
	 * 这样arr[i]才能在arr[k]的基础上构成一个新的递增子序列。
	 */
	public void lis(int[] a){
		if(dp == null){
			dp = new int[a.length+1];
			for(int i = 0;i<dp.length;i++){
				dp[i] = 1;
			}
		}
		for(int i=1;i<a.length;i++){
			for(int j = 0;j<i;j++){
				if(a[i] > a[j] && dp[i] < dp[j]+1){
					dp[i] = dp[j] +1;
					lis = dp[i];
				}
			}
		}
	}
	
	public void print(int[] a,int index){
		boolean flag = false;
		if(index < 0 || lis == 0){
			return;
		}
		if(dp[index] == lis){
			--lis;
			flag = true;
		}
		print(a,--index);
		if(flag){
			System.out.println(a[index+1]);
		}
		
	}
}
