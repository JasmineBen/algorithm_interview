package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 */
public class 查询二叉搜索树的第K个节点 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		查询二叉搜索树的第K个节点 test = new 查询二叉搜索树的第K个节点();
		test.KthNode(root, 1);
	}
	
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(k == 0 || count(pRoot) < k){
			return null;
		}
		return KthNode2(pRoot, k);	
	}

	TreeNode KthNode2(TreeNode pRoot, int k) {
		if(k == 0){
			return pRoot;
		}
		int leftCount = count(pRoot.left);
		if(leftCount + 1 == k){
			return pRoot;
		}else if(leftCount >= k){
			return KthNode(pRoot.left, k);
		}else{
			return KthNode(pRoot.right, k-count(pRoot.left)-1);
		}
		
	}
	
	int count(TreeNode node){
		if(node == null){
			return 0;
		}else{
			return 1 + count(node.left) + count(node.right);
		}
	}
}
