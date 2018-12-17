package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 */
public class 树的序列化 {
	
	private int index = -1;
	
	public static void main(String[] args) {
		树的序列化 test = new 树的序列化();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(test.Serialize(root));
		System.out.println(test.Deserialize(test.Serialize(root)).val);
	}

	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if(root == null){
			sb.append("*").append(";");
		}else{
			sb.append(root.val).append(";");
			sb.append(Serialize(root.left));
			sb.append(Serialize(root.right));
		}
		return sb.toString();
	}

	TreeNode Deserialize(String str) {
		if(str == null || str.isEmpty()){
			return null;
		}
		String[] s = str.split(";");
		return Deserialize2(s);
	}
	
	TreeNode Deserialize2(String[] s) {
		index++;
		if (index >= s.length) {
			return null;
		}
		
		if ("*".equals(s[index])) {
			return null;
		} else {
			TreeNode node = new TreeNode(Integer.valueOf(s[index]));
			node.left = Deserialize2(s);
			node.right = Deserialize2(s);
			return node;
		}
	}
}
