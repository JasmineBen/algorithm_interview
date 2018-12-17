package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 
 *  1 2 3 4
 *  5 6 7 8 
 *  9 10 11 12 
 *  13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */
public class 顺时针打印二维数组 {
	
	public static void main(String[] args) {
		int[][] a = new int[][]{{1},{2},{3},{4}};
		ArrayList<Integer> result = printMatrix(a);
		for(int i = 0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		int circles = (rows > columns) ? (columns / 2 + columns % 2) : (rows / 2 + rows % 2);
		for (int i = 0; i < circles; i++) {// 打印每一圈数据（上右下左）
			for (int j = i; j < columns - i; j++) {// 上
				result.add(matrix[i][j]);
			}

			for (int j = i + 1; j < rows - i; j++) {// 右
				result.add(matrix[j][columns - i - 1]);
			}

			for (int j = columns - i - 2; j >= i && i != rows - i - 1; j--) {// 下(当只有一行时存在和上方的重复)
				result.add(matrix[rows - i - 1][j]);
			}

			for (int j = rows - i - 2; j > i && columns - circles - i != 0; j--) {// 左(当只有一列时存在和右方的重复)
				result.add(matrix[j][i]);
			}

		}
		return result;
	}
}
