package com.datastructure.graph;

public class TinyEWG {
	public ��Ȩ������ͼ G;
	
	public TinyEWG(){
		G = new ��Ȩ������ͼ(8);
		��Ȩ������� e1 = new ��Ȩ�������(0,7,0.16f);
		��Ȩ������� e2 = new ��Ȩ�������(1,7,0.19f);
		��Ȩ������� e3 = new ��Ȩ�������(0,2,0.26f);
		��Ȩ������� e4 = new ��Ȩ�������(2,3,0.17f);
		��Ȩ������� e5 = new ��Ȩ�������(5,7,0.28f);
		��Ȩ������� e6 = new ��Ȩ�������(4,5,0.35f);
		��Ȩ������� e7 = new ��Ȩ�������(6,2,0.40f);
		G.addEdge(e1);
		G.addEdge(e2);
		G.addEdge(e3);
		G.addEdge(e4);
		G.addEdge(e5);
		G.addEdge(e6);
		G.addEdge(e7);
	}
}
