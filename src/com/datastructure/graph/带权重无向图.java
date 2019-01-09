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
public class 带权重无向图 {
	private int V;//顶点总数
	private int E;//边的总数
	private Map<Integer,List<带权重无向边>> adj;//临接表
	private List<带权重无向边> edges;
	
	public 带权重无向图(int v){
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
	
	public void addEdge(带权重无向边 e){
		edges.add(e);
		int v = e.either();
		int w = e.other(v);
		List<带权重无向边> vAdj = adj.get(v);
		if(vAdj == null){
			vAdj = new ArrayList<>();
		}
		vAdj.add(e);
		adj.put(v, vAdj);
		
		List<带权重无向边> wAdj = adj.get(w);
		if(wAdj == null){
			wAdj = new ArrayList<>();
		}
		wAdj.add(e);
		adj.put(w, wAdj);
	}
	
	public List<带权重无向边> adj(int v){
		return adj.get(v);
	}
	
	public List<带权重无向边> edges(){
		return edges;
	}
	
}
