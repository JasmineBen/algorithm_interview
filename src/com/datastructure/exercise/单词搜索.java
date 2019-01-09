package com.datastructure.exercise;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 */
public class 单词搜索 {
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(new 单词搜索().exist(board, "ABCCED"));
		System.out.println(new 单词搜索().exist(board, "SEE"));
		System.out.println(new 单词搜索().exist(board, "ABCB"));
	}

	/**
	 * 回溯算法
	 * 首先从二维数组里面查找，找到一个跟word字符串的首字母相同的字母。
	 * 然后从这个字母为出发点，向上下左右四个方向查找，查找到跟word的第二个字母相同的字母，
	 * 然后再从取到的第二个字母的位置开始，向上下左右查找，查找到跟word的第三个字母相同的字母，
	 * 再从第三个字母的位置开始......直到查找到跟word的最后一个字母相同的字母，
	 * 那么就认为该二维数组按照题目的规则能够组成word这个字符串
	 */
	public boolean exist(char[][] board, String word) {
		if (board != null && board.length > 0) {
			boolean[][] visit = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					boolean exist = exist(visit,board,i,j,word,0);
					if(exist) {//找到结果了
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean exist(boolean[][] visit,char[][] board, int i, int j, String word, int index) {
		if (index >= word.length()) {
			// 找到解了
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(index) || visit[i][j]) {
			//当前元素正在访问，越界或者当前字符不匹配，返回false
			return false;
		}
		visit[i][j] = true;
		boolean result = exist(visit,board,i-1,j,word,index+1) 
				|| exist(visit,board,i+1,j,word,index+1)
				|| exist(visit,board,i,j-1,word,index+1)
				|| exist(visit,board,i,j+1,word,index+1);
		visit[i][j] = false;
		return result;
	}
}
