package com.datastructure.graph;

/**
 * 带权重的有向边
 * 
 * @author admin
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

	private float weight;// 边的权重
	private int v;// 顶点之一
	private int w;// 另一个顶点

	public DirectedEdge(int v, int w, float weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	@Override
	public int compareTo(DirectedEdge that) {
		if (this.weight < that.weight) {
			return -1;
		} else if (this.weight > that.weight) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Edge [weight=" + weight + ", v=" + v + ", w=" + w + "]";
	}

}
