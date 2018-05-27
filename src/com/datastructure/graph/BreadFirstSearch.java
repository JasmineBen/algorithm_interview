package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 深度优先遍历
 * @author admin
 *
 */
public class BreadFirstSearch {

	private boolean[] marked;//该顶点调用过dfs了么
	private int count;//和S联通的顶点数
	private int[] edgeTo;//从起点到一个顶点已知路径上的最后一个顶点
	private int S;//起点
	private Graph G;
	
	public static void main(String[] args) {
		Graph graph = new Graph(7, false);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(5, 3);
		
		BreadFirstSearch test = new BreadFirstSearch(graph, 0);
		test.pathTo(4);
	}
	
	/**
	 * 以S点为顶点深度优先遍历
	 * @param G
	 * @param s
	 */
	public BreadFirstSearch(Graph G,int s){
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.G = G;
		this.S = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<>();
		marked[s] = true;
		count++;
		queue.add(s);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			System.out.println(v);
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;// 从W到S的路径最后一个顶点为S
					queue.add(w);
				}
			}
		}
	}
	
	/**
	 * 从起点S到v的路径
	 * @param v
	 */
	public void pathTo(int v) {
		if (hasPathTo(v)) {
			Stack<Integer> path = new Stack<>();
			for (int x = v; x != S; x = edgeTo[x]) {
				path.push(x);
			}
			path.push(S);
			while(!path.isEmpty()){
				System.out.println(path.pop());
			}
		}
	}
	
	/**
	 * 起点到V之间存在路径吗
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	
	/**
	 * 与S联通顶点数
	 * @return
	 */
	public int count(){
		return count;
	}
}
