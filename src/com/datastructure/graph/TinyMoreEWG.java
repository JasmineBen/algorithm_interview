package com.datastructure.graph;

public class TinyMoreEWG {
	
	public EdgeWeightedGraph G;

	public TinyMoreEWG(){
		G = new EdgeWeightedGraph(8);
		Edge e1 = new Edge(4, 5, 0.35f);
		Edge e2 = new Edge(4, 7, 0.37f);
		Edge e3 = new Edge(5, 7, 0.28f);
		Edge e4 = new Edge(0, 7, 0.16f);
		Edge e5 = new Edge(1, 5, 0.32f);
		Edge e6 = new Edge(0, 4, 0.38f);
		Edge e7 = new Edge(2, 3, 0.17f);
		Edge e8 = new Edge(1, 7, 0.19f);
		Edge e9 = new Edge(0, 2, 0.26f);
		Edge e10 = new Edge(1, 2, 0.36f);
		Edge e11 = new Edge(1, 3, 0.29f);
		Edge e12 = new Edge(2, 7, 0.34f);
		Edge e13 = new Edge(6, 2, 0.40f);
		Edge e14 = new Edge(3, 6, 0.52f);
		Edge e15 = new Edge(6, 0, 0.58f);
		Edge e16 = new Edge(6, 4, 0.93f);
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
