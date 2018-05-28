package com.datastructure.basic;


public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}
