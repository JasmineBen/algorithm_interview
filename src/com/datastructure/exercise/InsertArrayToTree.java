package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/*
 * 编写一个程序，把一个有序整数数组放到二叉树中
 */
public class InsertArrayToTree {

	public static void main(String[] args) {
		int[] a = new int[]{2,3,5,6,8,10};
		int middle = (a.length-1)/2;
		TreeNode node = new TreeNode(a[middle]);
		node.left = insert(a,0,middle-1);
		node.right = insert(a,middle+1,a.length-1);
		print(node);
	}
	
	
	public static TreeNode insert(int[] a,int start,int end){
		System.out.println("start:"+start+";end:"+end);
		if(start>end){
			return null;
		}
		if(start == end){
			return new TreeNode(a[start]);
		}
		int middle = (start + end)/2;
		TreeNode node = new TreeNode(a[middle]);
		node.left = insert(a,start,middle-1);
		node.right = insert(a,middle+1,end);
		return node;
	}
	
	public static void print(TreeNode node) {
		if (node != null) {
			print(node.left);
			System.out.print(node.val + ";");
			print(node.right);
		}
	}
}
