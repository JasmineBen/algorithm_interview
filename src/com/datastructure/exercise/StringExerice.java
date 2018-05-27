package com.datastructure.exercise;

public class StringExerice {

	/**
	 * 判断字符数组中的字符是否都是唯一的，要求时间复杂度为O(N),空间复杂度为O(1)
	 * 1、先使用堆排序进行chars中的数组排序
	 */
	public static boolean isUnique(char[] chars){
		heapSort(chars);
		for(int i=0;i<chars.length-1;i++){
			if(chars[i+1] == chars[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 堆是一个完全二叉树，大根堆中，所有的根节点的值都大于它的孩子。将大根堆按照层次遍历存储到数组中，
	 * 有如下关系：chars[i]>char[2i+1] && chars[i]>char[2i+2]
	 * @param chars
	 */
	public static void heapSort(char[] chars){
		//构建了一个大根堆，但不是有序的
		for(int i=chars.length/2-1;i>=0;i--){
			adjustHeap(chars, i, chars.length);
		}
		//将根元素与最后一个节点交换，交换完成后需要重新调整最后元素之前的堆结构，实现从小到大的排序
		for(int i=chars.length-1;i>=0;i--){
			char top = chars[i];
			chars[i] = chars[0];
			chars[0] = top;
			adjustHeap(chars, 0, i);
		}
	}
	
	//调整堆结构
	public static void adjustHeap(char[] chars,int i,int len){
		char temp = chars[i];
		for(int k=2*i+1;k<len;k=2*k+1){
			if(k+1<len && chars[k]<chars[k+1]){
				k++;
			}
			if(chars[k] > temp){//交换了k和i，k的子树的堆特性可能发生变化，需要继续向下调整
				chars[i] = chars[k];
				i = k;
			}else{
				break;
			}
		}
		chars[i] = temp;
	}
}
