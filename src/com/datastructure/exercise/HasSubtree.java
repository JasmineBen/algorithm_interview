package com.datastructure.exercise;

/**
 * 
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ�� ��ps������Լ��������������һ�������ӽṹ��
 */
public class HasSubtree {

	public static void main(String[] args) {
		HasSubtree test = new HasSubtree();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.left.left = new TreeNode(8);
		root1.left.right.right = new TreeNode(7);
		root1.right.left = new TreeNode(6);
		test.HasSubtree(root1, root1);

	}

	/**
	 * �ݹ�Ա���������������
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;

		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoesTree1HasTree2(root1, root2);
			}
			// �Ӹ��ڵ����������ʼƥ��Tree2
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			// ���������û��ƥ��ɹ���������������м���ƥ��Tree2
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}

		return result;
	}

	public boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if(root2 == null){//root2����������ƥ��ɹ�
			return true;
		}
		if(root1 == null){//root1������������root2��û�н�����ƥ��ʧ��
			return false;
		}
		if(root1.val != root2.val){
			return false;
		}
		//�������ڵ���ͬ���ֱ�Ա���������������
		return DoesTree1HasTree2(root1.left,root2.left) && DoesTree1HasTree2(root1.right,root2.right);
	}

	private String preTree(TreeNode root, String s) {
		s += root.val;
		if (root.left != null || root.right != null) {
			if (root.left != null) {
				preTree(root.left, s);
			}
			if (root.right != null) {
				preTree(root.right, s);
			}
		}
		return s;
	}

	private static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

	}
}
