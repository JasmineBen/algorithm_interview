package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class ������� {

	
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else{
			return Math.max(TreeDepth(root.right), TreeDepth(root.left)) + 1;
		}
	}
}
