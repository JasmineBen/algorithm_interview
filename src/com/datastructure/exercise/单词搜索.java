package com.datastructure.exercise;

/**
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * ʾ��:
 * board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
 * ���� word = "ABCCED", ���� true.
 * ���� word = "SEE", ���� true.
 * ���� word = "ABCB", ���� false.
 *
 */
public class �������� {
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(new ��������().exist(board, "ABCCED"));
		System.out.println(new ��������().exist(board, "SEE"));
		System.out.println(new ��������().exist(board, "ABCB"));
	}

	/**
	 * �����㷨
	 * ���ȴӶ�ά����������ң��ҵ�һ����word�ַ���������ĸ��ͬ����ĸ��
	 * Ȼ��������ĸΪ�����㣬�����������ĸ�������ң����ҵ���word�ĵڶ�����ĸ��ͬ����ĸ��
	 * Ȼ���ٴ�ȡ���ĵڶ�����ĸ��λ�ÿ�ʼ�����������Ҳ��ң����ҵ���word�ĵ�������ĸ��ͬ����ĸ��
	 * �ٴӵ�������ĸ��λ�ÿ�ʼ......ֱ�����ҵ���word�����һ����ĸ��ͬ����ĸ��
	 * ��ô����Ϊ�ö�ά���鰴����Ŀ�Ĺ����ܹ����word����ַ���
	 */
	public boolean exist(char[][] board, String word) {
		if (board != null && board.length > 0) {
			boolean[][] visit = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					boolean exist = exist(visit,board,i,j,word,0);
					if(exist) {//�ҵ������
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean exist(boolean[][] visit,char[][] board, int i, int j, String word, int index) {
		if (index >= word.length()) {
			// �ҵ�����
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(index) || visit[i][j]) {
			//��ǰԪ�����ڷ��ʣ�Խ����ߵ�ǰ�ַ���ƥ�䣬����false
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
