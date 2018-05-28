package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.TreeNode;

/**
 * �������������������ڵ�����ˣ��뽫�ڵ���������
 * ����������������ڵ��ֵ������������������ֵ��С����������������ֵ��
 * �����������һ����������
 * @author zhoupeiyuan
 *
 */
public class AdjustmentMistakeSearchTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		node1.left = node3;
		node1.right = node4;
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		node2.left = node5;
		node2.right = node6;
		adjustment(root);
		print(root);
		
	}

	/**
	 * ��������������������϶��ǵ����ģ�����������ڵ�����ˣ� ��ô��������ĵõ����б��϶������εݼ���
	 * �Ľ�����������ķǵݹ��㷨����¼�ϴδ�ӡ�Ľڵ�pre���͵�ǰ��Ҫ��ӡ�Ľڵ�cur��
	 * �����һ�δ�ӡ�Ľڵ���ڱ�����Ҫ��ӡ�Ľڵ㣬��˵��pre�ڵ���ˡ�
	 * �ҵ���������ڵ㣬�����ڲ�ֵ����
	 * @param root
	 */
	public static void adjustment(TreeNode root) {
		if(root != null){
			TreeNode pre = null;//��һ����ӡ�Ľڵ�
			TreeNode cur = root;
			
			//�����Ե��Ľڵ�
			TreeNode errNode1 = null;
			TreeNode errNode2 = null;
			
			Stack<TreeNode> stack = new Stack<>();
			while (cur != null || !stack.isEmpty()) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				if(!stack.isEmpty()){
					//��ǰҪ��ӡ�Ľڵ�
					cur = stack.pop();
					if(pre != null && pre.val > cur.val){
						errNode1 = (errNode1==null)?pre:errNode1;
						errNode2 = cur;
					}
					pre = cur;
					cur = cur.right;
				}
			}
			if(errNode1 != null && errNode2 != null){
				int tmp = errNode1.val;
				errNode1.val = errNode2.val;
				errNode2.val = tmp;
			}
		}
	}

	public static void print(TreeNode root) {
		if(root != null){
			TreeNode cur = root;
			Stack<TreeNode> stack = new Stack<>();
			while (cur != null || !stack.isEmpty()) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				if(!stack.isEmpty()){
					//��ǰҪ��ӡ�Ľڵ�
					cur = stack.pop();
					System.out.println(cur.val);
					cur = cur.right;
				}
			}

		}
	}
}
