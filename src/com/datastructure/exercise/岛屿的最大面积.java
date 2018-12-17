package com.datastructure.exercise;

/**
 * ����һ��������һЩ 0 �� 1�ķǿն�ά���� grid , һ�� ���� �����ĸ����� (ˮƽ��ֱ) �� 1 (��������) ���ɵ���ϡ�
 * ����Լ����ά������ĸ���Ե����ˮ��Χ�š�
 * �ҵ������Ķ�ά���������ĵ��������(���û�е��죬�򷵻����Ϊ0��)
 * ʾ��1���������������������Ӧ���� 6,�������11,��Ϊ����ֻ�ܰ���ˮƽ�ʹ�ֱ�����1
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * 
 * ʾ��2���������������������Ӧ���� 0
 * [[0,0,0,0,0,0,0,0]]
 */
public class ����������� {

	
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
		System.out.println(new �����������().maxAreaOfIsland(grid));
	}
	
	/**
	 * ѭ������grid[i][j],�������area(i,j,grid,column,row)��Ϊarea(i,j)��ʾ��grid[i][j]��ʼ�����Ҵ�ֱ�������������
	 * ���grid[i][j]=1,��˵���õ��ǵ��죬area(i,j)=1+area(i-1,j)+area(i+1,j)+area(i,j-1)+area(i,j+1)
	 * �����ڼ���area(i-1,j)��ʱ����ܻ��ظ����㵽a[i,j],�����ڼ���area(i,j)֮ǰ��Ҫ������grid[i][j]=0,
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int area = 0;
		if (grid != null) {
			int column = grid.length;// ����
			int row = grid[0].length;// ����
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
		// �����߽�
		if (i < 0 || j < 0 || i >= column || j >= row || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;//��ʾgrid[i][j]�Ѿ������ʹ�������Ϊ���Ĵ�ֱ����ĵ�������Ѿ��������
		return 1 + area(i - 1, j, grid,column,row) + area(i + 1, j, grid,column,row)
			+ area(i, j - 1, grid,column,row) + area(i, j + 1, grid,column,row);
	}
}
