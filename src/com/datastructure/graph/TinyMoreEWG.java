package com.datastructure.graph;

public class TinyMoreEWG {
	
	public 带权重无向图 G;

	public TinyMoreEWG(){
		G = new 带权重无向图(8);
		带权重无向边 e1 = new 带权重无向边(4, 5, 0.35f);
		带权重无向边 e2 = new 带权重无向边(4, 7, 0.37f);
		带权重无向边 e3 = new 带权重无向边(5, 7, 0.28f);
		带权重无向边 e4 = new 带权重无向边(0, 7, 0.16f);
		带权重无向边 e5 = new 带权重无向边(1, 5, 0.32f);
		带权重无向边 e6 = new 带权重无向边(0, 4, 0.38f);
		带权重无向边 e7 = new 带权重无向边(2, 3, 0.17f);
		带权重无向边 e8 = new 带权重无向边(1, 7, 0.19f);
		带权重无向边 e9 = new 带权重无向边(0, 2, 0.26f);
		带权重无向边 e10 = new 带权重无向边(1, 2, 0.36f);
		带权重无向边 e11 = new 带权重无向边(1, 3, 0.29f);
		带权重无向边 e12 = new 带权重无向边(2, 7, 0.34f);
		带权重无向边 e13 = new 带权重无向边(6, 2, 0.40f);
		带权重无向边 e14 = new 带权重无向边(3, 6, 0.52f);
		带权重无向边 e15 = new 带权重无向边(6, 0, 0.58f);
		带权重无向边 e16 = new 带权重无向边(6, 4, 0.93f);
		G.addEdge(e1);
		G.addEdge(e2);
		G.addEdge(e3);
		G.addEdge(e4);
		G.addEdge(e5);
		G.addEdge(e6);
		G.addEdge(e7);
		G.addEdge(e8);
		G.addEdge(e9);
		G.addEdge(e10);
		G.addEdge(e11);
		G.addEdge(e12);
		G.addEdge(e13);
		G.addEdge(e14);
		G.addEdge(e15);
		G.addEdge(e16);
		
	}
	
}
