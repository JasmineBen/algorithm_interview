package com.datastructure.exercise;

/**
 * ����������У�LIS��
 * ��һ��һά����arr[i]�е�����������еĳ��ȣ���������1��-1��2��-3��4��-5��6��-7�У�
 * ����������г���Ϊ4��������1��2��4��6��Ҳ������-1��2��4��6��
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
	 * ��i��Ԫ��֮ǰ������������еĳ���Ҫô��1��������һ�����У���
	 * Ҫô���ǵ�i-1��Ԫ��֮ǰ������������м�1��������״̬���̣�
	 * LIS[i] = max{1,LIS[k]+1}�����У�
	 * ���������k<=i-1��arr[i] > arr[k]��
	 * ����arr[i]������arr[k]�Ļ����Ϲ���һ���µĵ��������С�
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
