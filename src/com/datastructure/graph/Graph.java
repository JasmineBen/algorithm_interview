package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����ͼ
 * @author admin
 *
 */
public class Graph {
	private final int V;//������
	private int E;//�ߵ�����
	private Map<Integer,List<Integer>> adj;//�ڽӱ�
	private boolean directed;
	
	public Graph(int v,boolean directed) {
		this.V = v;
		this.directed = directed;
		adj = new HashMap<>();
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public Map<Integer, List<Integer>> getAdj() {
		return adj;
	}

	public void setAdj(Map<Integer, List<Integer>> adj) {
		this.adj = adj;
	}

	public int getV() {
		return V;
	}
	
	public List<Integer> adj(int v){
		return adj.get(v);
	}
	
	/**
	 * ���һ����
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		List<Integer> vAdj = adj.get(v);
		if (vAdj == null) {
			vAdj = new ArrayList<>();
		}
		vAdj.add(w);
		adj.put(v, vAdj);

		if (!directed) {
			List<Integer> wAdj = adj.get(w);
			if (wAdj == null) {
				wAdj = new ArrayList<>();
			}
			wAdj.add(v);
			adj.put(w, wAdj);
		}
	}

}
