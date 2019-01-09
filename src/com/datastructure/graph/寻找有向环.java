package com.datastructure.graph;

import java.util.Stack;

/**
 * 寻找有向环
 * 
 * @author admin
 *
 */
public class 寻找有向环 {

	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;// 有向环的所有顶点
	private boolean[] onStack;// 递归调用栈上的所有顶点

	public static void main(String[] args) {
		有向图 graph = new 有向图(7);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(4, 6);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(6, 0);
		graph.addEdge(5, 3);
		寻找有向环 test = new 寻找有向环(graph);
		System.out.println(test.hasCycle());
	}

	public 寻找有向环(有向图 G) {
		onStack = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		marked = new boolean[G.getV()];
		cycle = new Stack<>();
		for (int v = 0; v < G.getV(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	private void dfs(有向图 G, int v) {
		onStack[v] = true;//当前正在正在深度遍历
		marked[v] = true;
		if (G.getAdj().get(v) != null) {
			for (int w : G.getAdj().get(v)) {
				if (hasCycle()) {
					return;
				}
				if (!marked[w]) {
					edgeTo[w] = v;
					dfs(G, w);
				} else if (onStack[w]) {// 找到环了
					cycle = new Stack<>();
					for (int x = v; x != w; x = edgeTo[x]) {
						cycle.push(x);
					}
					cycle.push(w);
					cycle.push(v);
				}
			}
		}
		//一次完整的dfs结束后所有onStack全部释放
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}
}
