package com.datastructure.search;


public class Node {
	public Key key;//键
	public Value val;//值
	public Node left,right;//左右子树
	public int N;//总结点
	public int height;//高度
	
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
