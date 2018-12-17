package com.datastructure.exercise;

/**
 * ����������У�LIS��
 * ��һ��һά����arr[i]�е�����������еĳ��ȣ���������1��-1��2��-3��4��-5��6��-7�У�
 * ����������г���Ϊ4��������1��2��4��6��Ҳ������-1��2��4��6��
 */
public class ����������� {
	
	private int[] dp;
	private int lis = 1;//��ĵ��������еĳ���
	
	public static void main(String[] args) {
		int[] a = new int[]{1,-1,2,-3,4,-5,6,-7};
		����������� test = new �����������();
		test.lis(a);
//		System.out.println(test.lis);
		test.print(a, a.length-1);
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
			dp = new int[a.length];
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
	
	/**
	 * lisΪ����������еĳ���
	 * �Ӻ���ǰ�������飬�ҵ�dp[index]=lis�ĵ�һ������������������������е����һ����
	 * ��Ȼ�������index-1��ǰ��פlis-1��Ӧ��������lis=0
	 * @param a
	 * @param index
	 */
	public void print(int[] a,int index){
		boolean bPrint = false;
		if(index < 0 || lis == 0){
			return;
		}
		if(dp[index] == lis){
			lis -= 1;
			bPrint = true;
		}
		index--;
		print(a, index);
		if(bPrint){
			System.out.println(a[index+1]);
		}
		
		
	}
}
