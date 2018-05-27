package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTree {

	/**
	 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ�� 
	 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
	 */
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();// ż��������
			Stack<TreeNode> nextStack = new Stack<TreeNode>();// ����������
			int lineNum = 0;
			stack.push(pRoot);
			while(!stack.isEmpty() || !nextStack.isEmpty()){
				ArrayList<Integer> item = new ArrayList<Integer>();
				while(!stack.isEmpty()){
					TreeNode node = stack.pop();
					item.add(node.val);
					if(node.left != null){
						nextStack.push(node.left);
					}
					if(node.right != null){
						nextStack.push(node.right);
					}
				}
				if(!item.isEmpty()){
					result.add(item);
				}
				item = new ArrayList<Integer>();
				while(!nextStack.isEmpty()){
					TreeNode node = nextStack.pop();
					item.add(node.val);
					if(node.right != null){
						stack.push(node.right);
					}
					if(node.left != null){
						stack.push(node.left);
					}
				}
				if(!item.isEmpty()){
					result.add(item);
				}
			}
		}
		return result; 
	}

	/**
	 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
	 * @param pRoot
	 * @return
	 */
	ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (pRoot != null) {
			queue.add(pRoot);
			queue.add(null);
			ArrayList<Integer> item = new ArrayList<Integer>();
			boolean quit = true;
			while (!queue.isEmpty()) {
				TreeNode curNode = queue.poll();
				if (curNode != null) {
					item.add(curNode.val);
					if (curNode.left != null) {
						quit = false;
						queue.add(curNode.left);
					}
					if (curNode.right != null) {
						quit = false;
						queue.add(curNode.right);
					}
				}else{
					result.add(item);
					item = new ArrayList<Integer>();
					if(quit){
						break;
					}else{
						quit = true;
						queue.add(null);
					}
				}

			}
		}
		return result;
	}
}
