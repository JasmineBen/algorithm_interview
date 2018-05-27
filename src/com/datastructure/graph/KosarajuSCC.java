package com.datastructure.graph;

/**
 * 强连通分量 Kosaraju算法
 * @author admin
 *
 */
public class KosarajuSCC {
	
	private int[] id;//顶点V所在的强连通分量id
	private int count;//强连通分量数
	private boolean[] marked;//是否被标记过
	
	public static void main(String[] args) {
		Digraph graph = new Digraph(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 0);
		graph.addEdge(1, 8);
		graph.addEdge(2, 1);
		graph.addEdge(2, 4);
		graph.addEdge(2, 7);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		graph.addEdge(5, 0);
		graph.addEdge(5, 6);
		graph.addEdge(7, 9);
		graph.addEdge(7, 4);
		graph.addEdge(8, 5);
		graph.addEdge(9, 2);
		KosarajuSCC test = new KosarajuSCC(graph);
		System.out.println(test.stronglyConnected(3, 1));
	}

	public KosarajuSCC(Digraph G){
		id = new int[G.getV()];
		marked = new boolean[G.getV()];
		//对G的反向图进行深度优先遍历
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		System.out.println("reverse size:"+order.reversePost().size());
		while(!order.reversePost().isEmpty()){
			int s = order.reversePost().pop();
			if(!marked[s]){
				dfs(G, s);
				System.out.println("-------------------");
				count++;
			}
		}
		System.out.println("count:"+count);
		
	}
	
	public void dfs(Digraph G,int s){
		System.out.println(s);
		marked[s] = true;
		id[s] = count;
		if(G.adj(s) != null){
			for(int w : G.adj(s)){
				if(!marked[w]){
					dfs(G, w);
				}
			}
		}
	}
	
	/**
	 * V到W是否强连通，V到W存在一条路径，W到V也存在一条路径
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean stronglyConnected(int v,int w){
		return id[v] == id[w];
	}
	
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}
}
