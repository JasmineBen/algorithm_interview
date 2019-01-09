package com.datastructure.graph;

/**
 * ����ͼ�Ŀɴ���
 * @author admin
 *
 */
public class ����ͼ�Ŀɴ��� {
	private boolean[] marked;
	
	public ����ͼ�Ŀɴ���(����ͼ G,int s){
		marked = new boolean[G.getV()];
	}
	
	private void dfs(����ͼ G,int s){
		marked[s] = true;
		for(int w : G.adj(s)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * ����S��V�Ƿ�ɴ�
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return marked[v];
	}
}
