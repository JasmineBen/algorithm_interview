package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * ���ݺ�����������飬�ؽ�����������
 *
 */
public class ReConstructSearchTree {

	
	public static void main(String[] args) {
		int[] post = new int[]{2,4,3,6,8,7,5};
		TreeNode root = reConstruct(post, 0, post.length-1);
		ErgodicTree.preOrder(root);
		ErgodicTree.preOrder2(root);
		ErgodicTree.midOrder(root);
		ErgodicTree.postOrder(root);
	}
	
	/**
	 * �������Ϊ ��-��-��
	 */
	public static TreeNode reConstruct(int[] post,int start,int end){
//		System.out.println("start:"+start+";end:"+end);
		if(start <= end && start>=0){
			TreeNode node = new TreeNode(post[end]);
			int leftEnd = -1;//��������endλ��
			int rightStart = -1;//��������startλ��
			for(int i=start;i<end;i++){
				if(post[i]>node.val){
					rightStart = i;
					break;
				}
			}
			if(rightStart == -1){//û��������
				leftEnd = end-1;
			}else{//��������
				leftEnd = rightStart-1;
			}
			node.left = reConstruct(post, start, leftEnd);
			node.right = reConstruct(post, rightStart, end-1);
			return node;
		}
		return null;
	}
}
