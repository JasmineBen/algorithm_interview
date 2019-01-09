package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  有向图
 * 
 * @author admin
 *
 */
public class 有向图 {
	private final int V;// 顶点数
	private int E;// 边的数量
	private Map<Integer, List<Integer>> adj;// 邻接表

	public 有向图(int v) {
		this.V = v;
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

	public List<Integer> adj(int v) {
		return adj.get(v);
	}

	/**
	 * 添加一个边
	 * 
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
		E++;
	}

	/**
	 * 反向图
	 * @return
	 */
	public 有向图 reverse() {
		有向图 R = new 有向图(V);
		for (int v = 0; v < V; v++) {
			if (adj.get(v) != null) {
				for (int w : adj.get(v)) {
					R.addEdge(w, v);
				}
			}
		}
		return R;
	}

}
