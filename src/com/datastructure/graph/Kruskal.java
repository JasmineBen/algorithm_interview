package com.datastructure.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kruskal��С�������㷨
 * @author admin
 *
 */
public class Kruskal {

	private Queue<Edge> mst;
	
	/**
	 * 1.�����еı߰��մ�С��������
	 * 2.ÿ��ȡ��С�ߣ������ǰѡ�����С�ߺ��Ѿ���ɵ���С������������ͬһ����ͨ�����У�
	 * �򽫵�ǰ��С�߼��룬����ѡ��ѡ����һ���ߡ�(�����Ѿ����ɵ���С���������ܹ��Ƶ����±ߵ�������������ͨ��)
	 * 3.����N-1����ʱ����С�������������ˡ�(N��ʾ����)
	 * @param G
	 */
	public Kruskal(EdgeWeightedGraph G){
		mst = new LinkedList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : G.edges()){
			pq.add(e);
		}
		UF uf = new UF(G.V());
		int count = G.V();
		while(count > 1){
			Edge min = pq.poll();
			int v = min.either();
			int w = min.other(v);
			if(!uf.connected(v,w)){
				mst.add(min);
				uf.union(v, w);
				count--;
			}
		}
		while(!mst.isEmpty()){
			System.out.println(mst.poll());
		}
	}
	
	public static void main(String[] args) {
		TinyEWG ewg = new TinyEWG();
		Kruskal test = new Kruskal(ewg.G);
	}
}
