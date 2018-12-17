package com.datastructure.exercise;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 */
public class 机器人在二维数组中的移动格数 {
	
	public static void main(String[] args) {
		机器人在二维数组中的移动格数 test = new 机器人在二维数组中的移动格数();
		System.out.println(test.movingCount(5,10,10));
	}
	
	private int mCount = 0;
	public int movingCount(int threshold, int rows, int cols) {
		if(threshold < 0 || rows < 0 || cols < 0 || (rows == 0&& cols == 0)){
			return 0;
		}
		return moving(threshold,rows,cols,0,0,new boolean[rows * cols]);
	}
	
	public int moving(int threshold, int rows, int cols, int i, int j, boolean[] checking) {
		int checkIndex = cols * i + j;
		if (i < 0 || j < 0 || i >= rows || j >= cols || checking[checkIndex]) {
			return 0;
		}
		checking[checkIndex] = true;
		if (checkSum(i, j, threshold)) {
			System.out.println(i + " " + j);
			mCount = 1 + moving(threshold, rows, cols, i - 1, j, checking)
					+ moving(threshold, rows, cols, i + 1, j, checking)
					+ moving(threshold, rows, cols, i, j - 1, checking)
					+ moving(threshold, rows, cols, i, j + 1, checking);
		} else {
			mCount = moving(threshold, rows, cols, i - 1, j, checking)
					+ moving(threshold, rows, cols, i, j - 1, checking);
		}

		return mCount;

	}
	
	private boolean checkSum(int i,int j,int threshold){
		String s1 = String.valueOf(i);
		String s2 = String.valueOf(j);
		int sum = 0;
		int zero = '0';
		for(int a = 0;a < s1.length();a++){
			sum += (s1.charAt(a) - zero);
		}
		for(int a = 0;a < s2.length();a++){
			sum += (s2.charAt(a) - zero);
		}
		return sum <= threshold;
				
	}
}
