package com.datastructure.graph;

public class Search {

	private Graph G;
	private int s;
	
	public Search(Graph G,int s){
		this.G = G;
		this.s = s;
	}
	
	/**
	 * V和S是联通的吗
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return false;
	}
	
	/**
	 * 与S联通顶点数
	 * @return
	 */
	public int count(){
		return 0;
	}
}
