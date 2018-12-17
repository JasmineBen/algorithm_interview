package com.datastructure.exercise;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
 * 例如 
 * a b c e 
 * s f c s 
 * a d e e 
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 */
public class 判断矩阵是否存在某个字符串的路径 {
	
	public static void main(String[] args) {
		char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
		char[] path = new char[]{'b','c','c','e','d'};
		char[] path1 = new char[]{'a','b','c','b'};
		判断矩阵是否存在某个字符串的路径 test =  new 判断矩阵是否存在某个字符串的路径();
		System.out.println(test.hasPath(matrix, 3, 4, path1));
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix != null && str != null && matrix.length > 0 && str.length >0){
			
			for(int i = 0;i< rows;i++){
				for(int j = 0;j<cols;j++){//每个点都可以作为起点
					boolean[] checking = new boolean[rows * cols];
					if(hasPath(matrix, rows, cols, i,j,str,0,checking)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param matrix 
	 * @param rows 行数
	 * @param cols 列数
	 * @param i 行号
	 * @param j 列号
	 * @param str 待检查路径
	 * @param k 待检查路径的index
	 * @param flag
	 * @return
	 */
	private boolean hasPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] checking) {
		int checkIndex = i * cols + j;//二维数组看做一维数组，按照行进行平铺 
		if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[checkIndex] != str[k] || checking[checkIndex]){
			return false;
		}
		if(k == str.length - 1){
			return true;
		}
		checking[checkIndex] = true;//标记正在检查当前位置
		if(hasPath(matrix,rows,cols,i-1,j,str,k+1,checking) 
				|| hasPath(matrix, rows, cols, i+1, j, str, k+1, checking)
				||hasPath(matrix, rows, cols, i, j-1, str, k+1, checking)
				||hasPath(matrix, rows, cols, i, j+1, str, k+1, checking)){
			return true;
		}
		checking[checkIndex] = false;//没有找到路径，当前位置设置为未访问过
		return false;
	}
}
