package com.datastructure.graph;

/**
 * union-find
 * ��ͨ���㷨
 * @author admin
 *
 */
public class UF {

	private int[] id;//����ID
	private int count;//��������
	
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
	
	//p��q��ͨ,��id[p] = id[q]
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
