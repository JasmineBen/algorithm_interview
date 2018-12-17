package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.datastructure.basic.TreeNode;

/**
 * 
 * 二叉树先序、中序、后序的非递归遍历
 */
public class 二叉树非递遍历 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		preOrder(root);
		preOrder2(root);
		midOrder(root);
		postOrder(root);
	}
	
	
	/**
	 * 先序遍历的非递归
	 * 根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。即对于任一结点，其可看做是根结点，因此可以直接访问，访问完之后，若其左孩子不为空，按相同规则访问它的左子树；当访问其左子树时，再访问它的右子树。
	 * 因此其处理过程如下：对于任一结点P：
	 * 1)访问结点P，并将结点P入栈;
	 * 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，
	 * 循环至1);若不为空，则将P的左孩子置为当前的结点P;
	 * 3)直到P为NULL并且栈为空，则遍历结束。
	 */
	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			TreeNode node = root;
			Stack<TreeNode> stack = new Stack<>();
			while (node != null || !stack.isEmpty()) {
				while (node != null) {
					result.add(node.val);
					stack.add(node);
					node = node.left;
				}

				if (!stack.isEmpty()) {
					node = stack.pop();
					node = node.right;
				}
			}
		}
		for(int i:result){
			System.out.print(i+",");
		}
		System.out.println();
		return result;
	}
	
	/**
	 * 前序遍历地二种写法
	 * 1、将根节点压入栈
	 * 2、栈非空时，取出栈顶元素top,并打印
	 * 3、依次压入top.right top.left，继续步骤2
	 */
	public static List<Integer> preOrder2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				result.add(node.val);
				if(node.right != null){
					stack.push(node.right);
				}
				if(node.left != null){
					stack.push(node.left);
				}
			}
		}
		for(int i:result){
			System.out.print(i+",");
		}
		System.out.println();
		return result;
	}
	
	/**
	 * 中序遍历---左根右
	 * 1、依次将root的左子树压入栈
	 * 2、如果左子树为空且栈非空，就取出栈顶元素top，打印top，并将当前节点指向top.right
	 */
	public static List<Integer> midOrder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root != null){
			Stack<TreeNode> stack = new Stack<>();
			TreeNode node = root;
			while(node != null || !stack.isEmpty()){
				while(node != null){
					stack.push(node);
					node = node.left;
				}
				if(!stack.isEmpty()){
					TreeNode pop = stack.pop(); 
					result.add(pop.val);
					node = pop.right;
				}
			}
		}
		for(int i:result){
			System.out.print(i+",");
		}
		System.out.println();
		return result;
	}
	
	/**
	 * 后序遍历----左右根
	 * 使用两个栈实现：
	 * 
	 */
	public static List<Integer> postOrder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root != null){
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			TreeNode node = root;
			stack1.push(node);
			while(!stack1.isEmpty()){
				node = stack1.pop();
				stack2.push(node);
				if(node.left != null){
					stack1.push(node.left);
				}
				if(node.right != null){
					stack1.push(node.right);
				}
			}
			while(!stack2.isEmpty()){
				result.add(stack2.pop().val);
			}
		}
		for(int i:result){
			System.out.print(i+",");
		}
		System.out.println();
		return result;
	}

}
