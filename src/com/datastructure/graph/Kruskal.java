package com.datastructure.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kruskal最小生成树算法
 * @author admin
 *
 */
public class Kruskal {

	private Queue<Edge> mst;
	
	/**
	 * 1.将所有的边按照从小到大排序
	 * 2.每次取最小边，如果当前选择的最小边和已经组成的最小生成树不处于同一个连通分量中，
	 * 则将当前最小边加入，否则选择选择下一条边。(即由已经生成的最小生成树中能够推倒出新边的两个顶点是连通的)
	 * 3.当有N-1个边时，最小生成树就生成了。(N表示顶点)
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
