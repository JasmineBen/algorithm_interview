package com.datastructure.exercise;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:
 * 不允许旋转信封。
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 */
public class 俄罗斯套娃信封问题 {
	
	public static void main(String[] args) {
		int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
		System.out.println(new 俄罗斯套娃信封问题().maxEnvelopes(envelopes));
	}

	/**
	 * 二维版的最长递增子序列
	 */
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes != null && envelopes.length > 0) {
			sort(envelopes);//先排序
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
	 * 给二维数组排序，第一次按照envelopes[i][0]排序，
	 * 第二次在envelopes[i][0]相等的情况下对envelopes[i][1]排序
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
