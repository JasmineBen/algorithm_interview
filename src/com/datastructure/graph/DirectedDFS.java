package com.datastructure.graph;

/**
 * ����ͼ�Ŀɴ���
 * @author admin
 *
 */
public class DirectedDFS {
	private boolean[] marked;
	
	public DirectedDFS(Digraph G,int s){
		marked = new boolean[G.getV()];
	}
	
	private void dfs(Digraph G,int s){
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
