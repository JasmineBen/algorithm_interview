package com.datastructure.exercise;

import java.util.Stack;

import com.datastructure.basic.TreeNode;

/**
 * 二叉搜索树中有两个节点调换了，请将节点修正过来
 * 二叉搜索树满足根节点的值大于其左子树的所有值，小于其右子树的所有值。
 * 中序遍历后是一个递增数组
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
	 * 二叉搜索树的中序遍历肯定是递增的，如果有两个节点调换了， 那么中序遍历的得到的列表，肯定有两次递减的
	 * 改进下中序遍历的非递归算法，记录上次打印的节点pre，和当前正要打印的节点cur。
	 * 如果上一次打印的节点大于本次正要打印的节点，就说明pre节点错了。
	 * 找到两个错误节点，交互内部值即可
	 * @param root
	 */
	public static void adjustment(TreeNode root) {
		if(root != null){
			TreeNode pre = null;//上一个打印的节点
			TreeNode cur = root;
			
			//两个对调的节点
			TreeNode errNode1 = null;
			TreeNode errNode2 = null;
			
			Stack<TreeNode> stack = new Stack<>();
			while (cur != null || !stack.isEmpty()) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				if(!stack.isEmpty()){
					//当前要打印的节点
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
					//当前要打印的节点
					cur = stack.pop();
					System.out.println(cur.val);
					cur = cur.right;
				}
			}

		}
	}
}
