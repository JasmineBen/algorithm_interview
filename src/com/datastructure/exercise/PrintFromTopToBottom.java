package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 *
 */
public class PrintFromTopToBottom {
	
	private ArrayList<Integer> result = new ArrayList<Integer>();
	private Queue<TreeNode> queue = new LinkedList<TreeNode>();
	
	public static void main(String[] args) {
		
	}

	/**
	 * �������Ĳ�α���
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		if(root != null){
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				result.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
		}
		return result;
	}
}
