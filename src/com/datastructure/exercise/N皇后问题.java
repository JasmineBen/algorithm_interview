package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * N*N�ľ����У�����N���ʺ��κ������ʺ�����ͬһ�С�ͬһ�С�ͬһб�ߣ�������еİڷ�λ��
 * ����: 4
 *���: [
 *[".Q..",  // �ⷨ 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 */
public class N�ʺ����� {
	//��Ҫ�ڷŵĻʺ�����
	int queensNum;
	//queens[i]=j��ʾ��i�еĵ�j�з���һ���ʺ�
	int[] queens;
	//columnExists[i]=true��ʾ��i���лʺ�
	boolean[] columnExists;
	
	/**
	 * б������μ�����أ�
	 * ����б���ϵ�ÿһ���������(i,j)������n*n�����̣���2n-1����б�ߣ����԰���б�ߵı�ż�Ϊ(x-y+n);
	 * ͬ����2n-1����б�ߣ���б�ߵı�ż�Ϊx+y
	 */
	//a[i]=true��ʾ��i����(/)б��  
	boolean[] a;//i = x+y
	//b[i]=true��ʾ��i����(\)б��
	boolean[] b;//i=x-y+n-1
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n > 0) {
			queensNum = n;
			queens = new int[n];
			columnExists = new boolean[n];
			a = new boolean[n * 2-1];
			b = new boolean[n * 2-1];
			print(result,0);
		}
		return result;
	}
	
	// �жϸ�λ���Ƿ��Ѿ�����һ���ʺ�,�����򷵻� true 
	 private boolean isExists(int row, int col) { 
		return (columnExists[col] || a[row + col] || b[row - col +queensNum-1]); 
	 }
	
	/**
	 * ��ӡrow�еĻʺ�λ��
	 */
	private void print(List<List<String>> result,int row) {
		// ����ÿһ��
		for (int column = 0; column < queensNum; column++) {
			if (!isExists(row, column)) {
				queens[row] = column;// ��row�е�column�аڷŻʺ�
				columnExists[column] = true;// ��column���Ѿ��лʺ���
				a[row+column] = true;//��б���лʺ���
				b[row-column +queensNum-1] = true;//��б���лʺ���
				if (row == queensNum-1) {
					result.add(printStr());
				} else {
					// �ڷ���һ�еĻʺ�
					print(result,row + 1);
				}
				// ������һ�������õĻʺ󣬼����� 
				columnExists[column] = a[row+column] = b[row-column +queensNum-1] = false; 
			}
		}
	}
	
	private List<String> printStr() {
		List<String> item = new ArrayList<>();
		for (int row = 0; row < queensNum; row++) {
			int queenIndex = queens[row];
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i<queensNum;i++) {
				if(i==queenIndex) {
					sb.append("Q");
				}else {
					sb.append(".");
				}
			}
			item.add(sb.toString());
		}
		return item;
	}
	
	public static void main(String[] args) {
		List<List<String>>  result = new N�ʺ�����().solveNQueens(4);
		for(List<String> item : result) {
			System.out.println(item);
		}
	}
}
