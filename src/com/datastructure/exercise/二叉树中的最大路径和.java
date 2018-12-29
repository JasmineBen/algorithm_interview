package com.datastructure.exercise;
import com.datastructure.basic.TreeNode;

/**
 * ����һ���ǿն����������������·���͡�
 * �����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
 * ����: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

 * ���: 42=(15+20+7)
 */
public class �������е����·���� {
	
	private int ret = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		�������е����·���� c = new �������е����·����();
		c.maxPathSum(root);
		System.out.println(c.ret);
	}

	/**
	 * ��������һ���ڵ�, �������·�������ýڵ�, ��ôֻ�������������:
     * 1. �����������������ɵĺ�·��ֵ�ϴ���Ǹ����ϸýڵ��ֵ���򸸽ڵ���ݹ������·��
     * 2. ���������������·����, ���ϸýڵ��ֵ���������յ����·��
	 */
	public int maxPathSum(TreeNode root) {
		getMax(root);
		return ret;
	}

	//�����ڵ�r�����·��ֵ
	private int getMax(TreeNode r) {
		if (r == null)
			return 0;
		int left = Math.max(0, getMax(r.left)); // �������·����Ϊ����Ӧ����0��ʾ���·������������
		int right = Math.max(0, getMax(r.right));
		ret = Math.max(ret, r.val + left + right); // �ж��ڸýڵ��������������·�����Ƿ���ڵ�ǰ���·����
		return Math.max(left, right) + r.val;
	}
}
