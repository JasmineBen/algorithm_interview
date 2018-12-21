package com.datastructure.exercise;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 * 表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数
 * 输入: 
 * [1,1,0],
 * [1,1,0],
 * [0,0,1]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 */
public class 朋友圈 {

	public static void main(String[] args) {
		int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(new 朋友圈().findCircleNum(nums));
	}
	
	/**
	 * 二维数组的宽高肯定一样
	 * 转化为图的遍历问题，从第一行的每个元素开始，做深度优先遍历，能访问到的节点
	 */
	public int findCircleNum(int[][] M) {
		if (M != null && M.length > 0) {
			//visited的长度为学生数量，visited[i]表示学生i的是否已经访问
			int[] visited = new int[M.length];
			int count = 0;
			for (int i = 0; i < M.length; i++) {
				if(visited[i] == 0) {
					dfs(M, visited, i);
					count++;
				}
			}
			return count;
		}
		return 0;
	}
	
	/**
	 * 搜索第i行，也就是查找i的所有朋友，
	 * 如果和j和i是朋友，且visited[j]没有被访问过，则标记visited[j]被访问过，然后查找j的朋友，即第j行；
	 * 如果j和i不是朋友，则继续寻找下一个j
	 */
	private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
        	//i j是朋友，且j没有被访问过
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
