package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 */
public class ������������������� {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode left =  new TreeNode(2);
		TreeNode right =  new TreeNode(8);
		root.left = left;
		root.right = right;
		TreeNode result = new �������������������().lowestCommonAncestor(root,left,right);
		System.out.println(result.val);
	}

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
		if(find(root,p) && find(root,q)) {
			if(find(root.left, p,q) != null){
				return find(root.left, p,q);
			}else if(find(root.right,p,q) != null){
				return find(root.right, p,q);
			}
			return root;
			
		}else {
			return null;
		}
	}
	
	//�ж�target�ڲ���root��Ϊ��������
	private boolean find(TreeNode root,TreeNode target) {
		if(root != null) {
			if(root == target) {
				return true;
			}
			return find(root.left,target) || find(root.right,target);
		}
		return false;
	}
}
