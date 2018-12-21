package com.datastructure.exercise;

/**
 * ����һЩ����˿�Ⱥ͸߶ȵ��ŷ⣬��Ⱥ͸߶�����������ʽ (w, h) ���֡�
 * ����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ������ŷ�Ϳ��ԷŽ���һ���ŷ����ͬ����˹����һ����
 * �����������ж��ٸ��ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ����棩��
 * ˵��:
 * ��������ת�ŷ⡣
 * ʾ��:
 * ����: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * ���: 3 
 * ����: ����ŷ�ĸ���Ϊ 3, ���Ϊ: [2,3] => [5,4] => [6,7]��
 *
 */
public class ����˹�����ŷ����� {
	
	public static void main(String[] args) {
		int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
		System.out.println(new ����˹�����ŷ�����().maxEnvelopes(envelopes));
	}

	/**
	 * ��ά��������������
	 */
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes != null && envelopes.length > 0) {
			sort(envelopes);//������
			int[] dp = new int[envelopes.length];
			for(int i = 0;i<dp.length;i++) {
				dp[i] = 1;
			}
			for (int i = 1; i < envelopes.length; i++) {
				for (int j = 0; j <= i; j++) {
					if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
						dp[i] = Math.max(dp[i],dp[j]+1);
					}
				}
			}
			int max = dp[0];
			for(int i=1;i<dp.length;i++) {
				if(dp[i] > max) {
					max = dp[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * ����ά�������򣬵�һ�ΰ���envelopes[i][0]����
	 * �ڶ�����envelopes[i][0]��ȵ�����¶�envelopes[i][1]����
	 */
	private void sort(int[][] envelopes) {
		for (int i = 0; i < envelopes.length;i++) {
			for (int j = envelopes.length-1; j > i; j--) {
				if (envelopes[j][0] < envelopes[j-1][0]) {
					int temp = envelopes[j][0];
					envelopes[j][0] = envelopes[j-1][0];
					envelopes[j-1][0] = temp;
					temp = envelopes[j][1];
					envelopes[j][1] = envelopes[j-1][1];
					envelopes[j-1][1] = temp;
				}
			}
		}
		
		for (int i = 0; i < envelopes.length;i++) {
			for (int j = envelopes.length-1; j > i; j--) {
				if (envelopes[j][0] == envelopes[j-1][0] && envelopes[j][1] < envelopes[j-1][1]) {
					int temp = envelopes[j][1];
					envelopes[j][1] = envelopes[j-1][1];
					envelopes[j-1][1] = temp;
				}
			}
		}
	}
}
