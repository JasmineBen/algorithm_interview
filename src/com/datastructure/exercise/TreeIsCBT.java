package com.datastructure.exercise;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.basic.TreeNode;

/**
 * 判断一颗树是否是完全二叉树
 *
 */
public class TreeIsCBT {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3= new TreeNode(3);
		TreeNode node4= new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		System.out.println(isCBT(root));
	}

	/**
	 * 层次遍历二叉树，从左到又，如果当前节点有右孩子却没有做孩子，直接返回false.
	 * 如果当前节点不是左右孩子全有，那么之后的孩子必须都是叶节点，否则返回false
	 * @param node
	 * @return
	 */
	public static boolean isCBT(TreeNode node){
		if(node == null){
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		boolean leaf = false;
		while(!queue.isEmpty()){
			TreeNode cur =  queue.poll();
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			//上一个节点不是左右孩子都有(只有左节点没有右节点)，那么后续节点必须都是叶子节点
			if(leaf && (left != null || right != null)){
				return false;
			}
			//左孩子为空，右孩子不为空
			if(left == null && right != null){
				return false;
			}
			
			if(left != null){
				queue.offer(left);
			}
			
			if(right != null){
				queue.offer(right);
			}else{//不是左右孩子都有，后续的节点必须都是叶子
				leaf = true;
			}
		}
		return true;
	}
}
