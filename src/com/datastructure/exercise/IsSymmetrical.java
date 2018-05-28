package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * �������ľ����壺Դ������ 
    	    1
    	   /  \
    	  2    2
    	 / \  / \
    	3  4 4   3
    	���������
    	    1
    	   /  \
    	  2   2
    	 / \  / \
    	3  4 4   3
 */
public class IsSymmetrical {

	public boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null){
			return true;
		}
		return check(pRoot.left, pRoot.right);
	}
	
	private boolean check(TreeNode leftNode,TreeNode rightNode){
		if(leftNode == null && rightNode == null){
			return true;
		}else if(leftNode != null && rightNode != null){
			if(leftNode.val != rightNode.val){
				return false;
			}else{
				return check(leftNode.left, rightNode.right) && check(leftNode.right , rightNode.left);
			}
		}else{
			return false;
		}
	}
	
}
