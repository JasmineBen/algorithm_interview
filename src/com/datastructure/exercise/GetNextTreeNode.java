package com.datastructure.exercise;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 */
public class GetNextTreeNode {

	private static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		if(pNode.right != null){//右子树不空,找到右子树的最左节点
			pNode = pNode.right;
			while(pNode.left != null){
				pNode = pNode.left;
			}
			return pNode;
		}
		
		//右子树为空，找到其父子树中，父节点是祖父节点左子树中的祖父节点
		while(pNode.next != null){
			if(pNode.next.left== pNode){
				return pNode.next;
			}
			pNode = pNode.next;
		}
		return null;
	}
}
