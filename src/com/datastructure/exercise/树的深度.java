package com.datastructure.exercise;

/**
 * 
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class ������� {

	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else{
			return Math.max(TreeDepth(root.right), TreeDepth(root.left)) + 1;
		}
	}
}
