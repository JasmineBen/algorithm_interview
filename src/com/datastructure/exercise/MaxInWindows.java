package com.datastructure.exercise;

import java.util.LinkedList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
 * ���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *  {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 *  {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *
 */
public class MaxInWindows {
	
	public static void main(String[] args) {
		int num[] = new int[]{8,7,6,5,4,3,2,1};
		int num1[] = new int[]{1,2,3,4,5,6,7,8};
		int num2[] = new int[]{2,3,4,2,6,2,5,1};
		MaxInWindows test = new MaxInWindows();
		int[] result = test.maxInWindows(num, 3);
		int[] result1 = test.maxInWindows(num1, 3);
		int[] result2 = test.maxInWindows(num2, 3);
		for(int i : result){
			System.out.print(num[i]+",");
		}
		System.out.println();
		for(int i : result1){
			System.out.print(num1[i]+",");	
		}
		System.out.println();
		for(int i : result2){
			System.out.print(num2[i]+",");	
		}
	}
	
	/**
	 * ʹ��˫�˶��������棬����ʼ�ձ��浱ǰ�������ڵ����ֵ
	 */
	public int[] maxInWindows(int[] num, int size) {
		int[] result = new int[num.length-size+1];
		LinkedList<Integer> pox = new LinkedList<>();
		for(int i = 0;i<num.length;i++){
			//ɾ����βС�ڵ���num[i]��Ԫ��
			while(!pox.isEmpty() && num[pox.peekLast()]<=num[i]){
				pox.pollLast();
			}
			pox.offerLast(i);
			//ɾ�����׹��ڵ�Ԫ��
			if(i-pox.peekFirst()==size){
				pox.pollFirst();
			}
			if(i>=size-1){//����ʹ��poll����Ϊ��Ԫ�ػ����ܳ�������һ����������
				result[i+1-size] = pox.peekFirst();
			}
		}
		return result;
	}
	
}
