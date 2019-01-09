package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * N*N的矩阵中，放置N个皇后，任何两个皇后不能在同一行、同一列、同一斜线，输出所有的摆放位置
 * 输入: 4
 *输出: [
 *[".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 */
public class N皇后问题 {
	//需要摆放的皇后数量
	int queensNum;
	//queens[i]=j表示第i行的第j列放置一个皇后
	int[] queens;
	//columnExists[i]=true表示第i列有皇后
	boolean[] columnExists;
	
	/**
	 * 斜线是如何计算的呢？
	 * 假设斜线上的每一点的坐标是(i,j)，对于n*n的棋盘，有2n-1条左斜线，可以把左斜线的编号记为(x-y+n);
	 * 同样有2n-1条右斜线，右斜线的编号记为x+y
	 */
	//a[i]=true表示第i条左(/)斜线  
	boolean[] a;//i = x+y
	//b[i]=true表示第i条右(\)斜线
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
	
	// 判断该位置是否已经存在一个皇后,存在则返回 true 
	 private boolean isExists(int row, int col) { 
		return (columnExists[col] || a[row + col] || b[row - col +queensNum-1]); 
	 }
	
	/**
	 * 打印row行的皇后位置
	 */
	private void print(List<List<String>> result,int row) {
		// 遍历每一列
		for (int column = 0; column < queensNum; column++) {
			if (!isExists(row, column)) {
				queens[row] = column;// 第row行的column列摆放皇后
				columnExists[column] = true;// 第column列已经有皇后了
				a[row+column] = true;//右斜线有皇后了
				b[row-column +queensNum-1] = true;//左斜线有皇后了
				if (row == queensNum-1) {
					result.add(printStr());
				} else {
					// 摆放下一列的皇后
					print(result,row + 1);
				}
				// 撤销上一步所放置的皇后，即回溯 
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
		List<List<String>>  result = new N皇后问题().solveNQueens(4);
		for(List<String> item : result) {
			System.out.println(item);
		}
	}
}
