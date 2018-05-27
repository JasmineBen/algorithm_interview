package com.datastructure.graph;

/**
 * union-find
 * 连通性算法
 * @author admin
 *
 */
public class UF {

	private int[] id;//分量ID
	private int count;//分量数量
	
	public UF(int N){
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i] = i;
		}
	}
	
	public int find(int p){
		return id[p];
	}
	
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	//p和q连通,则id[p] = id[q]
	public void union(int p,int q){
		int pId = find(p);
		int qId = find(q);
		if(pId != qId){
			for(int i = 0;i<id.length;i++){
				if(id[i] == pId){
					id[i] = qId;
				}
			}
		}
		count--;
	}
}
