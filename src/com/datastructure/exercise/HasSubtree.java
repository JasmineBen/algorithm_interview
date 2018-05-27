package com.datastructure.exercise;

/**
 * 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。 （ps：我们约定空树不是任意一个树的子结构）
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
	 * 递归对比左子树和又子树
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;

		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				result = DoesTree1HasTree2(root1, root2);
			}
			// 从根节点的左子树开始匹配Tree2
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			// 如果左子树没有匹配成功则继续在右子树中继续匹配Tree2
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}

		return result;
	}

	public boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if(root2 == null){//root2遍历结束，匹配成功
			return true;
		}
		if(root1 == null){//root1遍历结束，而root2还没有结束，匹配失败
			return false;
		}
		if(root1.val != root2.val){
			return false;
		}
		//子树根节点相同，分别对比左子树和右子树
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
