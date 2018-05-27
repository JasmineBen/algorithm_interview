package com.datastructure.exercise;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö������� ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�� ���ؽ������������ء�
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
		//�������������ҵ���Ԫ�ص�λ�ã���λ�����Ԫ��Ϊ���������ұ�Ԫ��Ϊ������
		for(int i = startIn;i<=endIn;i++){
			if(in[i] == rootNode.val){            
				rootNode.left = reConstruct(pre, startPre+1, i+startPre-startIn , in, startIn, i - 1);
				rootNode.right = reConstruct(pre, i-startIn+startPre+1,endPre, in, i+1, endIn);
			}
		}
		return rootNode;
	}
		
}
