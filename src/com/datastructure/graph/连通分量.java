package com.datastructure.graph;

/**
 * 使用深度优先算法找所有 连通分量
 * @author admin
 *
 */
public class 连通分量 {

	private int count;//连通分量的个数
	private boolean[] marked;
	private int[] id;
	
	public static void main(String[] args) {
		无向图 graph = new 无向图(13, false);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);
		
		连通分量 cc = new 连通分量(graph);
		System.out.println("count:"+cc.count);
	}
	
	public 连通分量(无向图 G){
		marked = new boolean[G.getV()];
		id = new int[G.getV()];
		for(int i = 0;i<G.getV();i++){//对每个顶点都做深度优先遍历
			if(!marked[i]){
				System.out.println("cc:"+i);
				dfs(G,i);
				count++;
			}
		}
	}
	
	private void dfs(无向图 G,int s){
		marked[s] = true;
		id[s] = count;//s在第几组连通分量中
		for(int w : G.adj(s)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * v和w是连通的吗
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean conneted(int v,int w){
		return id[v] == id[w];
	}
	
	/**
	 * 连通分量数
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * V所在的连通分量标示
	 * @param v
	 * @return
	 */
	public int id(int v){
		return id[v];
	}
}
