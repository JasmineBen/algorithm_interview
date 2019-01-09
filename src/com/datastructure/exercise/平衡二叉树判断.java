package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树判断 {
	
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root);
	}
	
	/**
	 * 当前节点的左右子树高度差<=1 ，而且左右子树为平衡二叉树
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			int leftDepth = treeDepth(root.left);
			int rightDepth = treeDepth(root.right);
			int diff = Math.abs(leftDepth - rightDepth);
			return diff < 2 && isBalanced(root.left) && isBalanced(root.right);
		}else{
			return true;
		}
	}
	
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else{
			return Math.max(treeDepth(root.right), treeDepth(root.left)) + 1;
		}
	}
}
