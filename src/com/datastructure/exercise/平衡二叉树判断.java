package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 
 * ����һ�ö��������жϸö������Ƿ���ƽ���������
 */
public class ƽ��������ж� {
	
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root);
	}
	
	/**
	 * ��ǰ�ڵ�����������߶Ȳ�<=1 ��������������Ϊƽ�������
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
