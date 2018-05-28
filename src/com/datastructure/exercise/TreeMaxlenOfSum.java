package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/*
 * 在二叉树找到累加值为指定值的最长路径
 */
public class TreeMaxlenOfSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(-9);
		root.left = node1;
		root.right = node2;
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(0);
		node1.left = node3;
		node1.right = node4;
		TreeNode node5 = new TreeNode(18);
		TreeNode node6 = new TreeNode(1);
		node2.left = node5;
		node2.right = node6;
		TreeNode node7 = new TreeNode(1);
		TreeNode node8 = new TreeNode(6);
		node4.left = node7;
		node4.right = node8;
		int maxLen = maxLen(root, 6, 0);
		System.out.println(maxLen);
	}
	
	public static int maxLen(TreeNode root,int sum,int len){
		System.out.println("sum:"+sum+";len:"+len);
		if(root == null){
			if(sum == 0){//找到一条路径
				return len;
			}else{//没有找到路径
				return -1;
			}
		}else{
			if(root.left == null){
				return maxLen(root.left, sum-root.val, len+1);
			}else if(root.right == null){
				return maxLen(root.right, sum-root.val, len+1);
			}
			return Math.max(maxLen(root.left, sum-root.val, len+1),maxLen(root.right, sum-root.val, len+1));
			
		}
	}
}
