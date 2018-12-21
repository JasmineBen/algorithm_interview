package com.datastructure.exercise;

/**
 * ������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B �����ѣ�B �� C �����ѣ�
 * ��ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
 * ����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1��
 * ��ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����
 * ������������ѧ���е���֪������Ȧ����
 * ����: 
 * [1,1,0],
 * [1,1,0],
 * [0,0,1]
 * ���: 2 
 * ˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ��
 * ��2��ѧ���Լ���һ������Ȧ�����Է���2��
 */
public class ����Ȧ {

	public static void main(String[] args) {
		int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(new ����Ȧ().findCircleNum(nums));
	}
	
	/**
	 * ��ά����Ŀ�߿϶�һ��
	 * ת��Ϊͼ�ı������⣬�ӵ�һ�е�ÿ��Ԫ�ؿ�ʼ����������ȱ������ܷ��ʵ��Ľڵ�
	 */
	public int findCircleNum(int[][] M) {
		if (M != null && M.length > 0) {
			//visited�ĳ���Ϊѧ��������visited[i]��ʾѧ��i���Ƿ��Ѿ�����
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
	 * ������i�У�Ҳ���ǲ���i���������ѣ�
	 * �����j��i�����ѣ���visited[j]û�б����ʹ�������visited[j]�����ʹ���Ȼ�����j�����ѣ�����j�У�
	 * ���j��i�������ѣ������Ѱ����һ��j
	 */
	private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
        	//i j�����ѣ���jû�б����ʹ�
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
