package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 
 * ���������������е�һ���ڵ㣬�ҵ��ýڵ�����������е���һ���ڵ�
 * ����ÿ���ڵ������ָ�����Һ��ӵ�ָ�룬����ָ�򸸽ڵ��ָ��
 *
 */
public class ��ӡ�����������������һ���ڵ� {

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
	 * �������������-��-�ҵ�˳������������¼������
	 * 1�����cur������������ônext�ڵ�����������������ӽڵ�
	 * 2�����curû������������Ϊ�����������
	 * 	2.1��cur�ڵ��������ڵ�����ӣ���ônext�ڵ�������ĸ��ڵ�
	 * 	2.2��cur�ڵ��������ڵ���Һ��ӣ���ô��cur�ڵ����ϲ��ң�
	 *  �ҵ�ĳ�����ڵ�A��A�ĸ��ڵ�ΪB����A��B����ڵ㣬��ôcur��next�ڵ�������B
	 */
	public static TreeNode getNext(TreeNode cur){
		if(cur != null){
			if(cur.right != null){//����������next�ڵ���������������ڵ�
				TreeNode next = cur.right;
				while(next != null && next.left != null){
					next = next.left;
				}
				return next;
			}else if(cur.parent != null){//û��������,�Ҳ��Ǹ��ڵ�
				if(cur == cur.parent.left){//cur���丸�ڵ��������
					return cur.parent;
				}else if(cur == cur.parent.right){//cur���丸�ڵ��������
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
