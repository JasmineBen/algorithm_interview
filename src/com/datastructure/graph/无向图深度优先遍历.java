package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ������ȱ���
 * @author admin
 *
 */
public class ����ͼ������ȱ��� {

	private boolean[] marked;//�ö�����ù�dfs��ô
	private int count;//��S��ͨ�Ķ�����
	private int[] edgeTo;//����㵽һ��������֪·���ϵ����һ������
	private int S;//���
	private ����ͼ G;
	
	public static void main(String[] args) {
		����ͼ graph = new ����ͼ(7, false);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(5, 3);
		
		����ͼ������ȱ��� test = new ����ͼ������ȱ���(graph, 0);
		test.pathTo(4);
	}
	
	/**
	 * ��S��Ϊ����������ȱ���
	 * @param G
	 * @param s
	 */
	public ����ͼ������ȱ���(����ͼ G,int s){
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.G = G;
		this.S = s;
		bfs(G,s);
	}
	
	private void bfs(����ͼ G, int s) {
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
					edgeTo[w] = v;// ��W��S��·�����һ������ΪS
					queue.add(w);
				}
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
