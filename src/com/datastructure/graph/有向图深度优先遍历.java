package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 有向图深度优先遍历 {

	private boolean marked[];
	private Queue<Integer> pre;// 所有顶点前序排列
	private Queue<Integer> post;// 所有顶点后序排列
	private Stack<Integer> reversePost;//所有顶点的逆后序排列

	public 有向图深度优先遍历(有向图 G) {
		marked = new boolean[G.getV()];
		pre = new LinkedList<>();
		post = new LinkedList<>();
		reversePost = new Stack<>();
		for (int v = 0; v < G.getV(); v++) {
			dfs(G, v);
		}
	}

	private void dfs(有向图 G, int s) {
		if(!marked[s]){
			pre.add(s);
			marked[s] = true;
			if (G.adj(s) != null) {
				for (int w : G.adj(s)) {
					dfs(G, w);
				}
			}
			post.add(s);
			reversePost.push(s);
		}
		
	}
	
	public Stack<Integer> reversePost(){
		return reversePost;
	}
}
