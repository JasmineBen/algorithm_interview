package com.datastructure.graph;

import java.util.List;

/**
 * ��������
 * @author admin
 *
 */
public class Topological {
	Digraph G;

	public Topological(Digraph G){
		this.G = G;
	}
	
	/**
	 * G�������޻�ͼ��
	 * @return
	 */
	public boolean isGAG(){
		return new DirectedCycle(G).hasCycle();
	}
	
	/**
	 * �������������ж���
	 * @return
	 */
	public List<Integer> order(){
		return null;
	}
}
