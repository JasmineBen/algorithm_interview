package com.datastructure.exercise;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 */
public class 二叉树的最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root != null && p != null && q != null) {
			if(root == p && root == q) {
				return root;
			}
			if (find(p, q)) {
				return p;
			}
			if (find(q, p)) {
				return q;
			}
			return find(root,p,q);
		}
		return null;
	}
	
	private TreeNode find(TreeNode root,TreeNode p,TreeNode q) {
		TreeNode lastNode = root;
		if(find(root,p) && find(root,q)) {
			if(find(root.left, p,q) != null){
				root = root.left;
			}else if(find(root.right,p,q) != null){
				root = root.right;
			}
			return find(root, p,q);
		}else {
			return lastNode;
		}
	}
	
	private boolean find(TreeNode root,TreeNode target) {
		if(root != null) {
			if(root != target) {
				return true;
			}
			return find(root.left,target) || find(root.right,target);
		}
		return false;
	}
}
