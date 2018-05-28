package com.datastructure.exercise;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.basic.TreeNode;

/**
 * �ж�һ�����Ƿ�����ȫ������
 *
 */
public class TreeIsCBT {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3= new TreeNode(3);
		TreeNode node4= new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		System.out.println(isCBT(root));
	}

	/**
	 * ��α����������������֣������ǰ�ڵ����Һ���ȴû�������ӣ�ֱ�ӷ���false.
	 * �����ǰ�ڵ㲻�����Һ���ȫ�У���ô֮��ĺ��ӱ��붼��Ҷ�ڵ㣬���򷵻�false
	 * @param node
	 * @return
	 */
	public static boolean isCBT(TreeNode node){
		if(node == null){
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		boolean leaf = false;
		while(!queue.isEmpty()){
			TreeNode cur =  queue.poll();
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			//��һ���ڵ㲻�����Һ��Ӷ���(ֻ����ڵ�û���ҽڵ�)����ô�����ڵ���붼��Ҷ�ӽڵ�
			if(leaf && (left != null || right != null)){
				return false;
			}
			//����Ϊ�գ��Һ��Ӳ�Ϊ��
			if(left == null && right != null){
				return false;
			}
			
			if(left != null){
				queue.offer(left);
			}
			
			if(right != null){
				queue.offer(right);
			}else{//�������Һ��Ӷ��У������Ľڵ���붼��Ҷ��
				leaf = true;
			}
		}
		return true;
	}
}
