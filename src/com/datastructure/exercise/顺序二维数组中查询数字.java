package com.datastructure.exercise;


/**
 *  在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class 顺序二维数组中查询数字 {
	
	public static void main(String[] args) {
		int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		顺序二维数组中查询数字 search = new 顺序二维数组中查询数字();
		System.out.println(search.find(7,array));
		System.out.println(search.find(20,array));
	}
	
	/**
	 * 输入：
	 * 1,2,8,9
	 * 2,4,9,12
	 * 4,7,10,13
	 * 6,8,11,15
	 * 步骤：
	 * 1、初始化indexRow = 0,indexColumn = columns - 1
	 * 2、从最右上角的元素开始判断，如果array[indexRow][indexColumn]==n,直接返回true
	 * 3、如果array[indexRow][indexColumn]>n,则说明第indexColumn列的元素全部大于n,
	 * 则从indexColumn-1列接着查找,indexColumn=indexColumn-1
	 * 4、如果array[indexRow][indexColumn]<n,则说明第indexRow行的元素全部小于n,
	 * 则从indexRow+1行接着查找,indexRow=indexRow+1
	 */
	public boolean find(int n, int[][] array) {
		if (array != null && array.length > 0) {
			int rows = array.length;// 行数
			int columns = array[0].length;// 列数
			int indexRow = 0;
			int indexColumn = columns - 1;
			while (indexColumn >= 0 && indexRow < rows) {
				if (n < array[indexRow][indexColumn]) {
					indexColumn--;
				} else if (n > array[indexRow][indexColumn]) {
					indexRow++;
				} else {
					return true;
				}
			}
		}
		return false;
	}

}
