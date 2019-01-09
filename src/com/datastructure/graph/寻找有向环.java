package com.datastructure.graph;

import java.util.Stack;

/**
 * Ѱ������
 * 
 * @author admin
 *
 */
public class Ѱ������ {

	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;// ���򻷵����ж���
	private boolean[] onStack;// �ݹ����ջ�ϵ����ж���

	public static void main(String[] args) {
		����ͼ graph = new ����ͼ(7);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(4, 6);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(6, 0);
		graph.addEdge(5, 3);
		Ѱ������ test = new Ѱ������(graph);
		System.out.println(test.hasCycle());
	}

	public Ѱ������(����ͼ G) {
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

	private void dfs(����ͼ G, int v) {
		onStack[v] = true;//��ǰ����������ȱ���
		marked[v] = true;
		if (G.getAdj().get(v) != null) {
			for (int w : G.getAdj().get(v)) {
				if (hasCycle()) {
					return;
				}
				if (!marked[w]) {
					edgeTo[w] = v;
					dfs(G, w);
				} else if (onStack[w]) {// �ҵ�����
					cycle = new Stack<>();
					for (int x = v; x != w; x = edgeTo[x]) {
						cycle.push(x);
					}
					cycle.push(w);
					cycle.push(v);
				}
			}
		}
		//һ��������dfs����������onStackȫ���ͷ�
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}
}
