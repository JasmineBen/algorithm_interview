package com.datastructure.search;


public class Node {
	public Key key;//��
	public Value val;//ֵ
	public Node left,right;//��������
	public int N;//�ܽ��
	public int height;//�߶�
	
	public Node(Key key,Value value){
		this.key = key;
		this.val = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val==null?"null":"val:"+val.val;
	}
	
}
