package com.datastructure.exercise;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 */
public class ReConstructBinaryTree {


	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode rootNode = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return rootNode;
	}

	private TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if(startPre > endPre || startIn>endIn){
			return null;
		}
		System.out.println("startPre:"+startPre+";endPre:"+endPre+";startIn:"+startIn+";endIn:"+endIn);
		TreeNode rootNode = new TreeNode(pre[startPre]);
		//在中序数组中找到根元素的位置，该位置左边元素为左子树，右边元素为右子树
		for(int i = startIn;i<=endIn;i++){
			if(in[i] == rootNode.val){            
				rootNode.left = reConstruct(pre, startPre+1, i+startPre-startIn , in, startIn, i - 1);
				rootNode.right = reConstruct(pre, i-startIn+startPre+1,endPre, in, i+1, endIn);
			}
		}
		return rootNode;
	}
		
}
