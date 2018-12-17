package com.datastructure.exercise;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * 示例1：对于下面这个给定矩阵应返回 6,结果不是11,因为岛屿只能包含水平和垂直方向的1
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * 
 * 示例2：对于下面这个给定矩阵应返回 0
 * [[0,0,0,0,0,0,0,0]]
 */
public class 岛屿的最大面积 {

	
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int[][] grid = {{0,0,0}};
		System.out.println(new 岛屿的最大面积().maxAreaOfIsland(grid));
	}
	
	/**
	 * 循环遍历grid[i][j],面积函数area(i,j,grid,column,row)记为area(i,j)表示以grid[i][j]开始，查找垂直方向的最大面积。
	 * 如果grid[i][j]=1,则说明该点是岛屿，area(i,j)=1+area(i-1,j)+area(i+1,j)+area(i,j-1)+area(i,j+1)
	 * 由于在计算area(i-1,j)的时候可能会重复计算到a[i,j],所以在计算area(i,j)之前需要先设置grid[i][j]=0,
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int area = 0;
		if (grid != null) {
			int column = grid.length;// 行数
			int row = grid[0].length;// 列数
			for (int i = 0; i < column; i++) {
				for (int j = 0; j < row; j++) {
					if(grid[i][j] == 1) {
						area = Math.max(area(i, j, grid, column, row), area);
					}
				}
			}
		}
		return area;
	}
	
	private int area(int i, int j, int[][] grid,int column,int row) {
		// 超出边界
		if (i < 0 || j < 0 || i >= column || j >= row || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;//表示grid[i][j]已经被访问过，以他为起点的垂直方向的岛屿面积已经计算过了
		return 1 + area(i - 1, j, grid,column,row) + area(i + 1, j, grid,column,row)
			+ area(i, j - 1, grid,column,row) + area(i, j + 1, grid,column,row);
	}
}
