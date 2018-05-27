package com.datastructure.exercise;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 *
 */
public class TreeMirror {

	/**
	 * 递归交换左右子树
	 * @param root
	 */
	public void Mirror(TreeNode root) {
        if(root != null){
        	TreeNode left = root.left;
        	root.left = root.right;
        	root.right = left;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }

	private static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

	}
}
