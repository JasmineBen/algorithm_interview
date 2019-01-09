package com.datastructure.graph;

/**
 * ʹ����������㷨������ ��ͨ����
 * @author admin
 *
 */
public class ��ͨ���� {

	private int count;//��ͨ�����ĸ���
	private boolean[] marked;
	private int[] id;
	
	public static void main(String[] args) {
		����ͼ graph = new ����ͼ(13, false);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);
		
		��ͨ���� cc = new ��ͨ����(graph);
		System.out.println("count:"+cc.count);
	}
	
	public ��ͨ����(����ͼ G){
		marked = new boolean[G.getV()];
		id = new int[G.getV()];
		for(int i = 0;i<G.getV();i++){//��ÿ�����㶼��������ȱ���
			if(!marked[i]){
				System.out.println("cc:"+i);
				dfs(G,i);
				count++;
			}
		}
	}
	
	private void dfs(����ͼ G,int s){
		marked[s] = true;
		id[s] = count;//s�ڵڼ�����ͨ������
		for(int w : G.adj(s)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * v��w����ͨ����
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean conneted(int v,int w){
		return id[v] == id[w];
	}
	
	/**
	 * ��ͨ������
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * V���ڵ���ͨ������ʾ
	 * @param v
	 * @return
	 */
	public int id(int v){
		return id[v];
	}
}
