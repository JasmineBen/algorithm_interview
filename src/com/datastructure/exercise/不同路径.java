package com.datastructure.exercise;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class 不同路径 {
	
	public static void main(String[] args) {
		System.out.println(new 不同路径().uniquePaths(7, 3));
	}

	/**
	 * 动态规划
	 * 数组a[m][n],求a[0][0]到a[m][n]的路径总和
	 * 对于a[i][j]，有上左2个选择,设dp[i][j]为a[0][0]到a[i][j]的不同路径
	 */
	public int uniquePaths(int m, int n) {
		if (m > 0 && n > 0) {
			int[][] dp = new int[m][n];
			dp[0][0] = 1;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					dp[i + 1][j] = Math.max(dp[i][j],dp[i + 1][j]);
					dp[i][j + 1] =  Math.max(dp[i][j],dp[i][j+1]);
					dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
			return dp[m - 1][n - 1];
		}
		return 0;
	}
}
