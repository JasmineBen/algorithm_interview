package com.datastructure.exercise;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。 
 *
 */
public class ConvertBinaryTree {

	/**
	 * 
	 *1.将左子树构造成双链表，并返回链表头节点。
     *2.定位至左子树双链表最后一个节点。
     *3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     *4.将右子树构造成双链表，并返回链表头节点。
     *5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     *6.根据左子树链表是否为空确定返回的节点。
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null){
			return null;
		}
		if(pRootOfTree.left == null && pRootOfTree.right == null){
			return pRootOfTree;
		}
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		while(p != null && p.right != null){
			p = p.right;
		}
		if(left != null){
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
		TreeNode right = Convert(pRootOfTree.right);
		if(right != null){
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		return left != null ? left : pRootOfTree;
	}
	

}
