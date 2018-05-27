package com.datastructure.graph;

/**
 * ��Ȩ�صı�
 * @author admin
 *
 */
public class Edge implements Comparable<Edge>{
	
	private float weight;//�ߵ�Ȩ��
	private int v;//����֮һ
	private int w;//��һ������
	
	public Edge(int v,int w,float weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int vertex){
		if(vertex == v){
			return w;
		}else if(vertex == w){
			return v;
		}else{
			throw new RuntimeException("Inconsistent edge");
		}
	}

	@Override
	public int compareTo(Edge that) {
		if(this.weight < that.weight){
			return -1;
		}else if(this.weight > that.weight){
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Edge [weight=" + weight + ", v=" + v + ", w=" + w + "]";
	}
	
	
}
