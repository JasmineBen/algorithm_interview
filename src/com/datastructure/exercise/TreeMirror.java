package com.datastructure.exercise;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 *
 */
public class TreeMirror {

	/**
	 * �ݹ齻����������
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
