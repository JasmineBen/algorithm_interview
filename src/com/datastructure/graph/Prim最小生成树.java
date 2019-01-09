package com.datastructure.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Prim��С�������㷨
 * @author admin
 *
 */
public class Prim��С������ {
	
	private boolean[] marked;//��С�������Ķ���
	private Queue<��Ȩ�������> mst;//��С�������ı�
	private PriorityQueue<��Ȩ�������> pq;//���б����ȶ���
	
	public static void main(String[] args) {
		TinyEWG ewg = new TinyEWG();
		Prim��С������ test = new Prim��С������(ewg.G);
	}
	
	/**
	 * ������һ�����㿪ʼ(�����0��ʼ)
	 * 1�����ʵ�ǰ����0����¼marked[0] = true
	 * 2�����0���ӵĶ����Ƿ��Ѿ�marked�����û�У��ͽ��߼������ȶ���pq
	 * 3��ѭ��ȡ��pq�е���СԪ�أ�������С�����������У�
	 * �жϸñߵ����������Ƿ���ʹ������û�з��ʣ���ֱ������������
	 * @param G
	 */
	public Prim��С������(��Ȩ������ͼ G){
		marked = new boolean[G.V()];
		mst = new LinkedList<>();
		pq = new PriorityQueue<>();
		visit(G, 0);
		while(!pq.isEmpty()){
			��Ȩ������� e = pq.poll();//ȡ��̱�
			mst.add(e);
			System.out.println(e);
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}
	
	private void visit(��Ȩ������ͼ G,int v){
		marked[v] = true;
		if(G.adj(v) != null){
			for(��Ȩ������� e : G.adj(v)){
				if(!marked[e.other(v)]){
					pq.add(e);
				}
			}
		}
	}

}
