package com.datastructure.exercise;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾��� 
 *  1 2 3 4
 *  5 6 7 8 
 *  9 10 11 12 
 *  13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */
public class ˳ʱ���ӡ��ά���� {
	
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
		for (int i = 0; i < circles; i++) {// ��ӡÿһȦ���ݣ���������
			for (int j = i; j < columns - i; j++) {// ��
				result.add(matrix[i][j]);
			}

			for (int j = i + 1; j < rows - i; j++) {// ��
				result.add(matrix[j][columns - i - 1]);
			}

			for (int j = columns - i - 2; j >= i && i != rows - i - 1; j--) {// ��(��ֻ��һ��ʱ���ں��Ϸ����ظ�)
				result.add(matrix[rows - i - 1][j]);
			}

			for (int j = rows - i - 2; j > i && columns - circles - i != 0; j--) {// ��(��ֻ��һ��ʱ���ں��ҷ����ظ�)
				result.add(matrix[j][i]);
			}

		}
		return result;
	}
}
