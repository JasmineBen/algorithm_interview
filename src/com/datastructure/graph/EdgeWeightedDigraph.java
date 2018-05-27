package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 带权重的无向图
 * @author admin
 *
 */
public class EdgeWeightedDigraph {
	private int V;//顶点总数
	private int E;//边的总数
	private Map<Integer,List<DirectedEdge>> adj;//临接表
	private List<DirectedEdge> edges;
	
	public EdgeWeightedDigraph(int v){
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
	
	public void addEdge(DirectedEdge e){
		edges.add(e);
		int v = e.from();
		int w = e.to();
		List<DirectedEdge> vAdj = adj.get(v);
		if(vAdj == null){
			vAdj = new ArrayList<>();
		}
		vAdj.add(e);
		adj.put(v, vAdj);
		
		E++;
	}
	
	public List<DirectedEdge> adj(int v){
		return adj.get(v);
	}
	
	public List<DirectedEdge> edges(){
		return edges;
	}
	
}
