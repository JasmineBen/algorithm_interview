package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ�� 
 * ����������������
 *
 */
public class ����������ת˫���� {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		root = Convert(root);
		TreeNode last = null;
		while(root != null){
			System.out.print(root.val+";");
			root = root.right;
			if(root != null){
				last = root;
			}
		}
		System.out.println();
		while(last != null){
			System.out.print(last.val+";");
			last = last.left;
		}
		
	}

	/**
	 * 
	 *1.�������������˫��������������ͷ�ڵ㡣
     *2.��λ��������˫�������һ���ڵ㡣
     *3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
     *4.�������������˫��������������ͷ�ڵ㡣
     *5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
     *6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
	 */
	public static TreeNode Convert(TreeNode pRootOfTree) {
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
