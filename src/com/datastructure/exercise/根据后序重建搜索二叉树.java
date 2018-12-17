package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 根据后序遍历的数组，重建搜索二叉树
 *
 */
public class 根据后序重建搜索二叉树 {

	
	public static void main(String[] args) {
		int[] post = new int[]{2,4,3,6,8,7,5};
		TreeNode root = reConstruct(post, 0, post.length-1);
		二叉树非递遍历.preOrder(root);
		二叉树非递遍历.preOrder2(root);
		二叉树非递遍历.midOrder(root);
		二叉树非递遍历.postOrder(root);
	}
	
	/**
	 * 后序遍历为 左-右-根
	 */
	public static TreeNode reConstruct(int[] post,int start,int end){
//		System.out.println("start:"+start+";end:"+end);
		if(start <= end && start>=0){
			TreeNode node = new TreeNode(post[end]);
			int leftEnd = -1;//左子树的end位置
			int rightStart = -1;//右子树的start位置
			for(int i=start;i<end;i++){
				if(post[i]>node.val){
					rightStart = i;
					break;
				}
			}
			if(rightStart == -1){//没有右子树
				leftEnd = end-1;
			}else{//有右子树
				leftEnd = rightStart-1;
			}
			node.left = reConstruct(post, start, leftEnd);
			node.right = reConstruct(post, rightStart, end-1);
			return node;
		}
		return null;
	}
}
