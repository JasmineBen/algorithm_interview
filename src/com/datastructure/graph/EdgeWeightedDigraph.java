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
public class EdgeWeightedDigraph {
	private int V;//��������
	private int E;//�ߵ�����
	private Map<Integer,List<DirectedEdge>> adj;//�ٽӱ�
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
