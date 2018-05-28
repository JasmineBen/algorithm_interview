package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö������� ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�� ���ؽ������������ء�
 */
public class ReConstructBinaryTree {

	public static void main(String[] args) {
//		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
//		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
//		TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
		getPostArray(new int[]{5,3,2,4,7,6,8},new int[]{2,3,4,5,6,7,8});
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode rootNode = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return rootNode;
	}

	private TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}
		System.out.println("startPre:" + startPre + ";endPre:" + endPre + ";startIn:" + startIn + ";endIn:" + endIn);
		TreeNode rootNode = new TreeNode(pre[startPre]);
		// �������������ҵ���Ԫ�ص�λ�ã���λ�����Ԫ��Ϊ���������ұ�Ԫ��Ϊ������
		for (int i = startIn; i <= endIn; i++) {
			if (in[i] == rootNode.val) {
				rootNode.left = reConstruct(pre, startPre + 1, i + startPre - startIn, in, startIn, i - 1);
				rootNode.right = reConstruct(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
			}
		}
		return rootNode;
	}

	/**
	 * �������� �����������ɺ�������
	 * 
	 * @param pre
	 * @param mid
	 * @return
	 */
	public static int[] getPostArray(int[] pre, int[] mid) {
		int[] post = new int[pre.length];
		fillArray(pre, 0, pre.length - 1, mid, 0, mid.length - 1, post, 0, post.length - 1);
		for(int i:post){
			System.out.println(i);
		}
		return post;
	}

	/**
	 * 
	 * @param pre ��������
	 * @param preStart ����startλ��
	 * @param preEnd ����endλ��
	 * @param mid ��������
	 * @param midStart ����startλ��
	 * @param midEnd ����endλ��
	 * @param res ��������
	 * @param postStart �����startλ��
	 * @param postEnd �����endλ��
	 */
	public static void fillArray(int[] pre,int preStart,int preEnd,
			int[] mid,int midStart,int midEnd,
			int[] res, int postStart, int postEnd) {
		if (preStart >= 0 && preStart <= preEnd && (preEnd - preStart == midEnd - midStart)) {
			System.out.println("preStart:"+preStart+";preEnd"+preEnd);
			System.out.println("midStart:"+midStart+";midEnd"+midEnd);
			System.out.println("postStart:"+postStart+";postEnd"+postEnd);

			res[postEnd] = pre[preStart];
			int leftCount = 0;
			for (int i = midStart; i < midEnd; i++) {
				if (mid[i] == res[postEnd]) {
					break;
				}
				leftCount++;
			}
			int rightCount = midEnd - midStart - leftCount;
			System.out.println("leftCount:"+leftCount+";rightCount"+rightCount);

			if (leftCount > 0) {
				fillArray(pre, preStart + 1, preStart + leftCount, mid, midStart, midStart + leftCount - 1, res,
						postStart, postStart + leftCount - 1);
			}
			if (rightCount > 0) {
				fillArray(pre, preEnd - rightCount + 1, preEnd, mid, midEnd - rightCount + 1, midEnd, res, postEnd-rightCount,
						postEnd-1);
			}
		}
	}

}
