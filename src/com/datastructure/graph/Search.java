package com.datastructure.graph;

public class Search {

	private Graph G;
	private int s;
	
	public Search(Graph G,int s){
		this.G = G;
		this.s = s;
	}
	
	/**
	 * V��S����ͨ����
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return false;
	}
	
	/**
	 * ��S��ͨ������
	 * @return
	 */
	public int count(){
		return 0;
	}
}
