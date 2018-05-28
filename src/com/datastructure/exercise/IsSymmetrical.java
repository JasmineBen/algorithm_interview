package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 二叉树的镜像定义：源二叉树 
    	    1
    	   /  \
    	  2    2
    	 / \  / \
    	3  4 4   3
    	镜像二叉树
    	    1
    	   /  \
    	  2   2
    	 / \  / \
    	3  4 4   3
 */
public class IsSymmetrical {

	public boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null){
			return true;
		}
		return check(pRoot.left, pRoot.right);
	}
	
	private boolean check(TreeNode leftNode,TreeNode rightNode){
		if(leftNode == null && rightNode == null){
			return true;
		}else if(leftNode != null && rightNode != null){
			if(leftNode.val != rightNode.val){
				return false;
			}else{
				return check(leftNode.left, rightNode.right) && check(leftNode.right , rightNode.left);
			}
		}else{
			return false;
		}
	}
	
}
