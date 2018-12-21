package com.datastructure.exercise;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 输入: 
 * 1 1 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 *
 */
public class 最大正方形 {
	
	public static void main(String[] args) {
		int[][] a = new int[1][1];
		System.out.println(a[0][0]);
	}

	/**
	 * dp[i][j]为以matrix[i][j]右下角顶点的正方形的最大边长；则有：
	 * matrix[i][j]=0时，dp[i][j]=0;
	 * matrix[i][j]=1时，dp[i][j]=1+min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
	 */
	public int maximalSquare(char[][] matrix) {
		int edge = 0;
		if (matrix != null && matrix.length > 0) {
			int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if(matrix[i][j] == '0') {
						dp[i][j] = 0;
					}else {
						int temp = Math.min(dp[i-1][j], dp[i][j-1]);
						dp[i][j] = Math.min(dp[i-1][j-1], temp) + 1;
					}
					edge = Math.max(edge, dp[i][j]);
				}
			}
		}
		return edge * edge;
	}
	
	
}
