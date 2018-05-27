package com.datastructure.graph;

/**
 * ��Ȩ�ص������
 * 
 * @author admin
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

	private float weight;// �ߵ�Ȩ��
	private int v;// ����֮һ
	private int w;// ��һ������

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
