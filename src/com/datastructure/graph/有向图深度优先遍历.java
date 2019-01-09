package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ����ͼ������ȱ��� {

	private boolean marked[];
	private Queue<Integer> pre;// ���ж���ǰ������
	private Queue<Integer> post;// ���ж����������
	private Stack<Integer> reversePost;//���ж�������������

	public ����ͼ������ȱ���(����ͼ G) {
		marked = new boolean[G.getV()];
		pre = new LinkedList<>();
		post = new LinkedList<>();
		reversePost = new Stack<>();
		for (int v = 0; v < G.getV(); v++) {
			dfs(G, v);
		}
	}

	private void dfs(����ͼ G, int s) {
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
