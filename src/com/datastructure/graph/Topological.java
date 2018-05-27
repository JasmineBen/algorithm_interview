package com.datastructure.graph;

import java.util.List;

/**
 * 拓扑排序
 * @author admin
 *
 */
public class Topological {
	Digraph G;

	public Topological(Digraph G){
		this.G = G;
	}
	
	/**
	 * G是有向无环图吗
	 * @return
	 */
	public boolean isGAG(){
		return new DirectedCycle(G).hasCycle();
	}
	
	/**
	 * 拓扑排序中所有顶点
	 * @return
	 */
	public List<Integer> order(){
		return null;
	}
}
