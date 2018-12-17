package com.datastructure.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.datastructure.basic.TreeNode;

/**
 * 
 * �������������򡢺���ķǵݹ����
 */
public class �������ǵݱ��� {
	
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
	 * ��������ķǵݹ�
	 * ����ǰ��������ʵ�˳�����ȷ��ʸ���㣬Ȼ���ٷֱ�������Ӻ��Һ��ӡ���������һ��㣬��ɿ����Ǹ���㣬��˿���ֱ�ӷ��ʣ�������֮���������Ӳ�Ϊ�գ�����ͬ���������������������������������ʱ���ٷ���������������
	 * ����䴦��������£�������һ���P��
	 * 1)���ʽ��P���������P��ջ;
	 * 2)�жϽ��P�������Ƿ�Ϊ�գ���Ϊ�գ���ȡջ����㲢���г�ջ����������ջ�������Һ�����Ϊ��ǰ�Ľ��P��
	 * ѭ����1);����Ϊ�գ���P��������Ϊ��ǰ�Ľ��P;
	 * 3)ֱ��PΪNULL����ջΪ�գ������������
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
	 * ǰ������ض���д��
	 * 1�������ڵ�ѹ��ջ
	 * 2��ջ�ǿ�ʱ��ȡ��ջ��Ԫ��top,����ӡ
	 * 3������ѹ��top.right top.left����������2
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
	 * �������---�����
	 * 1�����ν�root��������ѹ��ջ
	 * 2�����������Ϊ����ջ�ǿգ���ȡ��ջ��Ԫ��top����ӡtop��������ǰ�ڵ�ָ��top.right
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
	 * �������----���Ҹ�
	 * ʹ������ջʵ�֣�
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
