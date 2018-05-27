package com.datastructure.graph;

/**
 * 有向图的可达性
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
	 * 顶点S到V是否可达
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return marked[v];
	}
}
