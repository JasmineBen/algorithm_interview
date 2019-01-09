package com.datastructure.graph;

/**
 * 带权重的有向边
 * 
 * @author admin
 *
 */
public class 带权重有向边 implements Comparable<带权重有向边> {

	private float weight;// 边的权重
	private int v;// 顶点之一
	private int w;// 另一个顶点

	public 带权重有向边(int v, int w, float weight) {
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
	public int compareTo(带权重有向边 that) {
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
