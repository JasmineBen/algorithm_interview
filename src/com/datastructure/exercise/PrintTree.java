package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTree {

	/**
	 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印， 
	 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
	 */
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();// 偶数行数据
			Stack<TreeNode> nextStack = new Stack<TreeNode>();// 奇数行数据
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
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
