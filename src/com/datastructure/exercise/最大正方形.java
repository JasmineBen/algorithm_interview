package com.datastructure.exercise;

/**
 * ��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������
 * ����: 
 * 1 1 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * ���: 4
 *
 */
public class ��������� {
	
	public static void main(String[] args) {
		int[][] a = new int[1][1];
		System.out.println(a[0][0]);
	}

	/**
	 * dp[i][j]Ϊ��matrix[i][j]���½Ƕ���������ε����߳������У�
	 * matrix[i][j]=0ʱ��dp[i][j]=0;
	 * matrix[i][j]=1ʱ��dp[i][j]=1+min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
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
