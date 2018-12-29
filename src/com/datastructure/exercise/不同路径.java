package com.datastructure.exercise;

/**
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 * ���ܹ��ж�������ͬ��·����
 * ˵����m �� n ��ֵ�������� 100��
 * ʾ�� 1:
 * ����: m = 3, n = 2
 * ���: 3
 * ����:
 * �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
 * 1. ���� -> ���� -> ����
 * 2. ���� -> ���� -> ����
 * 3. ���� -> ���� -> ����
 */
public class ��ͬ·�� {
	
	public static void main(String[] args) {
		System.out.println(new ��ͬ·��().uniquePaths(7, 3));
	}

	/**
	 * ��̬�滮
	 * ����a[m][n],��a[0][0]��a[m][n]��·���ܺ�
	 * ����a[i][j]��������2��ѡ��,��dp[i][j]Ϊa[0][0]��a[i][j]�Ĳ�ͬ·��
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
