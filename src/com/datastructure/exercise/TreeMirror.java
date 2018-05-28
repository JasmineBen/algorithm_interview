package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.TreeNode;

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
	
	/**
	 * 非递归方法 
	 */
	public void Mirror2(TreeNode root) {
        if(root != null){
        	Stack<TreeNode> stack = new Stack<>();
        	stack.push(root);
        	while(!stack.isEmpty()){
        		TreeNode node = stack.pop();
        		TreeNode oldLeft = node.left;
        		node.left = node.right;
        		node.right = oldLeft;
            	if(node.left != null){
            		stack.push(node.left);
            	}
            	if(node.right != null){
            		stack.push(node.right);
            	}
        	}
        	
        }
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		ErgodicTree et = new ErgodicTree();
		TreeMirror treeMirror = new TreeMirror();
		treeMirror.Mirror2(root);
		et.preOrder(root);
		et.midOrder(root);
		et.postOrder(root);
	}
}
