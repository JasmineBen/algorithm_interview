package com.datastructure.exercise;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 */
public class VerifySquenceOfBST {

	public static void main(String[] args) {
		int[] a = new int[] { 1,2,3,4,5 };
		VerifySquenceOfBST test = new VerifySquenceOfBST();
		System.out.println(test.verifySquenceOfBST(a));
	}

	/**
	 * 二叉搜索数特性，左节点<根<小于右节点 后序遍历为：左子树,右子树，根
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean verifySquenceOfBST(int[] sequence) {
		if(sequence == null || sequence.length == 0){
			return false;
		}
		int size = sequence.length;
		int i = 0;
		while (--size > 0) {
			while (i < size && sequence[i++] < sequence[size]);
			while (i < size && sequence[i++] > sequence[size]);
			if (i < size){
				return false;
			}
			i = 0;
		}
		return true;
	}

}
