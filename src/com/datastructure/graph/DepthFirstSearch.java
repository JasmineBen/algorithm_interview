package com.datastructure.graph;

import java.util.Stack;

/**
 * ������ȱ���
 * @author admin
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;//�ö�����ù�dfs��ô
	private int count;//��S��ͨ�Ķ�����
	private int[] edgeTo;//����㵽һ��������֪·���ϵ����һ������
	private int S;//���
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
		
		DepthFirstSearch test = new DepthFirstSearch(graph, 0);
		test.pathTo(4);
	}
	
	/**
	 * ��S��Ϊ����������ȱ���
	 * @param G
	 * @param s
	 */
	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.G = G;
		this.S = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G,int s){
//		System.out.println(s);
		marked[s] = true;
		count++;
		for(int w : G.adj(s)){
			if(!marked[w]){
				edgeTo[w] = s;//��W��S��·�����һ������ΪS
				dfs(G, w);
			}
		}
	}
	
	/**
	 * �����S��v��·��
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
	 * ��㵽V֮�����·����
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	
	/**
	 * ��S��ͨ������
	 * @return
	 */
	public int count(){
		return count;
	}
}
