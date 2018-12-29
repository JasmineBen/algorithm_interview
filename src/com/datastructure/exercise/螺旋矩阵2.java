package com.datastructure.exercise;

import java.util.Stack;

/**
 * ����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
 * ʾ��:
 * ����: 3
 * ���:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 *
 */
public class ��������2 {
	
	public static void main(String[] args) {
		int[][] result = new ��������2().generateMatrix(3);
		for(int i = 0;i<result.length;i++) {
			for(int j = 0;j< result[0].length;j++) {
				System.out.print(result[i][j]+";");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		Stack<Integer> stack = new Stack<>();
		int count = n * n;
		while (count > 0) {
			stack.push(count);
			count--;
		}
		int[][] result = new int[n][n];
		int up = 0;
		int down = n - 1;
		int left = 0;
		int right = n - 1;
		while (true && !stack.isEmpty()) {
			for (int i = left; i <= right; i++) {
				result[up][i] = stack.pop();
			}
			if (++up > down) {
				break;
			}

			for (int i = up; i <= down; i++) {
				result[i][right] = stack.pop();
			}
			if (--right < left) {
				break;
			}

			for (int i = right; i >= left; i--) {
				result[down][i] = stack.pop();
			}
			if (--down < up) {
				break;
			}

			for (int i = down; i >= up; i--) {
				result[i][left] = stack.pop();
			}
			if (++left > right) {
				break;
			}
		}
		return result;
	}
}
