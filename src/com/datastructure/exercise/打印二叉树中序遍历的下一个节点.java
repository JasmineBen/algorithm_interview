package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 
 * 给定二叉树和其中的一个节点，找到该节点在中序遍历中的下一个节点
 * 树中每个节点除了有指向左右孩子的指针，还有指向父节点的指针
 *
 */
public class 打印二叉树中序遍历的下一个节点 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node2;
		node5.parent = node2;
		node6.parent = node3;
		node7.parent = node3;
		System.out.println(getNext(node1));
		System.out.println(getNext(node2));
		System.out.println(getNext(node3));
		System.out.println(getNext(node4));
		System.out.println(getNext(node5));
		System.out.println(getNext(node6));
		System.out.println(getNext(node7));
		
	}
	
	/**
	 * 中序遍历按照左-根-右的顺序遍历，有以下几种情况
	 * 1、如果cur有右子树，那么next节点就是右子树的最左子节点
	 * 2、如果cur没有右子树，分为以下两种情况
	 * 	2.1、cur节点是它父节点的左孩子：那么next节点就是他的父节点
	 * 	2.2、cur节点是它父节点的右孩子，那么从cur节点向上查找，
	 *  找到某个父节点A，A的父节点为B，且A是B的左节点，那么cur的next节点就是这个B
	 */
	public static TreeNode getNext(TreeNode cur){
		if(cur != null){
			if(cur.right != null){//有右子树，next节点是右子树的最左节点
				TreeNode next = cur.right;
				while(next != null && next.left != null){
					next = next.left;
				}
				return next;
			}else if(cur.parent != null){//没有右子树,且不是根节点
				if(cur == cur.parent.left){//cur是其父节点的左子树
					return cur.parent;
				}else if(cur == cur.parent.right){//cur是其父节点的右子树
					TreeNode parent = cur.parent;
					TreeNode parentParent = parent.parent;
					while(parentParent != null){
						if(parentParent.left != parent){
							parent = parentParent;
							parentParent = parent.parent;
						}
						return parentParent;
					}
				}
			}
		}
		return null;
	}
	
}
