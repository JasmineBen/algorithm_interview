package com.datastructure.exercise;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ�� 
 *
 */
public class ConvertBinaryTree {

	/**
	 * 
	 *1.�������������˫��������������ͷ�ڵ㡣
     *2.��λ��������˫�������һ���ڵ㡣
     *3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
     *4.�������������˫��������������ͷ�ڵ㡣
     *5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
     *6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
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
