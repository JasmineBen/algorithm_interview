package com.datastructure.graph;

public class TinyEWG {
	public 带权重无向图 G;
	
	public TinyEWG(){
		G = new 带权重无向图(8);
		带权重无向边 e1 = new 带权重无向边(0,7,0.16f);
		带权重无向边 e2 = new 带权重无向边(1,7,0.19f);
		带权重无向边 e3 = new 带权重无向边(0,2,0.26f);
		带权重无向边 e4 = new 带权重无向边(2,3,0.17f);
		带权重无向边 e5 = new 带权重无向边(5,7,0.28f);
		带权重无向边 e6 = new 带权重无向边(4,5,0.35f);
		带权重无向边 e7 = new 带权重无向边(6,2,0.40f);
		G.addEdge(e1);
		G.addEdge(e2);
		G.addEdge(e3);
		G.addEdge(e4);
		G.addEdge(e5);
		G.addEdge(e6);
		G.addEdge(e7);
	}
}
