package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	输出: [1,2,3,6,9,8,7,4,5]
	示例 2:
	输入:
	[
	  [1, 2, 3, 4],
	  [5, 6, 7, 8],
	  [9,10,11,12]
	]
	输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class 螺旋矩阵 {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> result = new 螺旋矩阵().spiralOrder(matrix);
		System.out.println(result);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix != null && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			int up = 0;
			int down = m - 1;
			int left = 0;
			int right = n - 1;
			while (true) {
				for (int i = left; i <= right; i++) {
					result.add(matrix[up][i]);
				}
				if (++up > down) {
					break;
				}

				for (int i = up; i <= down; i++) {
					result.add(matrix[i][right]);
				}
				if (--right < left) {
					break;
				}

				for (int i = right; i >= left; i--) {
					result.add(matrix[down][i]);
				}
				if (--down < up) {
					break;
				}

				for (int i = down; i >= up; i--) {
					result.add(matrix[i][left]);
				}
				if(++left > right) {
					break;
				}
			}
		}
		return result;
	}
}
