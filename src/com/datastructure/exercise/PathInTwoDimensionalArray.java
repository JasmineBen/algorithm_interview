package com.datastructure.exercise;

/**
 * 回溯法
 * 
 * 设计一个函数，用来判断二维数组中是否存在一条包含某个字符串所有字符的路径，
 * 路径可以从矩阵的任意位置开始，每一步可以在矩阵的左、右、上、下移动一个，如果一条路径经过了矩阵的某一格，
 * 那么该路径不能再次进入该格子。例如下面的矩阵包含一条bfce的矩阵 
 * a b t g
 * c f c s 
 * j d e h
 *
 */
public class PathInTwoDimensionalArray {
	
	public static void main(String[] args) {
		char[][] chars = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
		System.out.println(findPath(chars, "bfce"));
	}

	public static boolean findPath(char[][] chars, String path) {
		boolean[][] visited = new boolean[chars.length][chars[0].length];
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[0].length; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[0].length; j++) {
				if (hasPath(chars, i, j, path, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasPath(char[][] chars, int row, int col, String path, int pathIndex, boolean[][] visited) {
		if (pathIndex >= path.length()) {
			return true;
		}
		boolean hasPath = false;
		if (row >=0 && col >= 0 && row < chars.length && col < chars[0].length && !visited[row][col]
				&& path.charAt(pathIndex) == chars[row][col]) {
			System.out.println("row:"+row+"col:"+col+";pathIndex:"+pathIndex);
			visited[row][col] = true;
			hasPath = hasPath(chars, row - 1, col, path, pathIndex + 1, visited)
					|| hasPath(chars, row + 1, col, path, pathIndex + 1, visited)
					|| hasPath(chars, row, col + 1, path, pathIndex + 1, visited)
					|| hasPath(chars, row, col - 1, path, pathIndex + 1, visited);
			if(!hasPath){
				visited[row][col] = false;
			}
			return hasPath;
		}
		return false;
	}
}
