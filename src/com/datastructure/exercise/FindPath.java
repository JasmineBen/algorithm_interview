package com.datastructure.exercise;

import java.util.ArrayList;


/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 */
public class FindPath {
	
	private ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		FindPath test = new FindPath();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(12);
		test.findPath(null, 0);
		System.out.println(test.array.size());
	}

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if(root == null && target == 0){
			return array;
		}
		findPath(new ArrayList<Integer>(), root, target);
		return array;
	}
	
	public void findPath(ArrayList<Integer> list,TreeNode root, int target) {
		if(root == null){
			if(target == 0){
				array.add(list);
			}
		}else if(root.left != null && root.right != null){
			list.add(root.val);
			ArrayList<Integer> rightList = new ArrayList<Integer>();
			rightList.addAll(list);
			findPath(list, root.left, target - root.val);
			findPath(rightList, root.right, target - root.val);
		}else if(root.left != null){
			list.add(root.val);
			findPath(list, root.left, target - root.val);
		}else if( root.right != null){
			list.add(root.val);
			findPath(list, root.right, target - root.val);
		}else{
			list.add(root.val);
			findPath(list, root.right, target - root.val);
		}
	}

}
