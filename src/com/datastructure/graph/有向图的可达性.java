package com.datastructure.graph;

/**
 * 有向图的可达性
 * @author admin
 *
 */
public class 有向图的可达性 {
	private boolean[] marked;
	
	public 有向图的可达性(有向图 G,int s){
		marked = new boolean[G.getV()];
	}
	
	private void dfs(有向图 G,int s){
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
