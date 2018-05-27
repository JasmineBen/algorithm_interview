package com.datastructure.graph;

public class TinyEWG {
	public EdgeWeightedGraph G;
	
	public TinyEWG(){
		G = new EdgeWeightedGraph(8);
		Edge e1 = new Edge(0,7,0.16f);
		Edge e2 = new Edge(1,7,0.19f);
		Edge e3 = new Edge(0,2,0.26f);
		Edge e4 = new Edge(2,3,0.17f);
		Edge e5 = new Edge(5,7,0.28f);
		Edge e6 = new Edge(4,5,0.35f);
		Edge e7 = new Edge(6,2,0.40f);
		G.addEdge(e1);
		G.addEdge(e2);
		G.addEdge(e3);
		G.addEdge(e4);
		G.addEdge(e5);
		G.addEdge(e6);
		G.addEdge(e7);
	}
}
