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
public class ��Ȩ������ͼ {
	private int V;//��������
	private int E;//�ߵ�����
	private Map<Integer,List<��Ȩ�������>> adj;//�ٽӱ�
	private List<��Ȩ�������> edges;
	
	public ��Ȩ������ͼ(int v){
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
	
	public void addEdge(��Ȩ������� e){
		edges.add(e);
		int v = e.from();
		int w = e.to();
		List<��Ȩ�������> vAdj = adj.get(v);
		if(vAdj == null){
			vAdj = new ArrayList<>();
		}
		vAdj.add(e);
		adj.put(v, vAdj);
		
		E++;
	}
	
	public List<��Ȩ�������> adj(int v){
		return adj.get(v);
	}
	
	public List<��Ȩ�������> edges(){
		return edges;
	}
	
}
