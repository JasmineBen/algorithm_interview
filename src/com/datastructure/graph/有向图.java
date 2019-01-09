package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  ����ͼ
 * 
 * @author admin
 *
 */
public class ����ͼ {
	private final int V;// ������
	private int E;// �ߵ�����
	private Map<Integer, List<Integer>> adj;// �ڽӱ�

	public ����ͼ(int v) {
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
	 * ���һ����
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
	 * ����ͼ
	 * @return
	 */
	public ����ͼ reverse() {
		����ͼ R = new ����ͼ(V);
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
