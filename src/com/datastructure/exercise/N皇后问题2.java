package com.datastructure.exercise;

public class N�ʺ�����2 {

	// ��Ҫ�ڷŵĻʺ�����
	int queensNum;
	// queens[i]=j��ʾ��i�еĵ�j�з���һ���ʺ�
	int[] queens;
	// columnExists[i]=true��ʾ��i���лʺ�
	boolean[] columnExists;

	/**
	 * б������μ�����أ� ����б���ϵ�ÿһ���������(i,j)������n*n�����̣���2n-1����б�ߣ����԰���б�ߵı�ż�Ϊ(x-y+n);
	 * ͬ����2n-1����б�ߣ���б�ߵı�ż�Ϊx+y
	 */
	// a[i]=true��ʾ��i����(/)б��
	boolean[] a;// i = x+y
	// b[i]=true��ʾ��i����(\)б��
	boolean[] b;// i=x-y+n-1
	int count = 0;

	public int totalNQueens(int n) {
		if (n > 0) {
			queensNum = n;
			queens = new int[n];
			columnExists = new boolean[n];
			a = new boolean[n * 2 - 1];
			b = new boolean[n * 2 - 1];
			print(0);
		}
		return count;
	}

	// �жϸ�λ���Ƿ��Ѿ�����һ���ʺ�,�����򷵻� true
	private boolean isExists(int row, int col) {
		return (columnExists[col] || a[row + col] || b[row - col + queensNum - 1]);
	}

	/**
	 * ��ӡrow�еĻʺ�λ��
	 */
	private void print(int row) {
		// ����ÿһ��
		for (int column = 0; column < queensNum; column++) {
			if (!isExists(row, column)) {
				queens[row] = column;// ��row�е�column�аڷŻʺ�
				columnExists[column] = true;// ��column���Ѿ��лʺ���
				a[row + column] = true;// ��б���лʺ���
				b[row - column + queensNum - 1] = true;// ��б���лʺ���
				if (row == queensNum - 1) {
					count++;
				} else {
					// �ڷ���һ�еĻʺ�
					print(row + 1);
				}
				// ������һ�������õĻʺ󣬼�����
				columnExists[column] = a[row + column] = b[row - column + queensNum - 1] = false;
			}
		}
	}

}
