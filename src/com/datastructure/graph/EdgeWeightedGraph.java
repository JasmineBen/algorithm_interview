package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��Ȩ�ص�����ͼ
 * @author admin
 *
 */
public class EdgeWeightedGraph {
	private int V;//��������
	private int E;//�ߵ�����
	private Map<Integer,List<Edge>> adj;//�ٽӱ�
	private List<Edge> edges;
	
	public EdgeWeightedGraph(int v){
		this.V = v;
		this.E = 0;
		adj = new HashMap<>();
		edges = new ArrayList<>();
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(Edge e){
		edges.add(e);
		int v = e.either();
		int w = e.other(v);
		List<Edge> vAdj = adj.get(v);
		if(vAdj == null){
			vAdj = new ArrayList<>();
		}
		vAdj.add(e);
		adj.put(v, vAdj);
		
		List<Edge> wAdj = adj.get(w);
		if(wAdj == null){
			wAdj = new ArrayList<>();
		}
		wAdj.add(e);
		adj.put(w, wAdj);
	}
	
	public List<Edge> adj(int v){
		return adj.get(v);
	}
	
	public List<Edge> edges(){
		return edges;
	}
	
}
