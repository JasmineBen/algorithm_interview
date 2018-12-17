package com.datastructure.exercise;


/**
 *  ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 *  �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 *
 */
public class ˳���ά�����в�ѯ���� {
	
	public static void main(String[] args) {
		int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		˳���ά�����в�ѯ���� search = new ˳���ά�����в�ѯ����();
		System.out.println(search.find(7,array));
		System.out.println(search.find(20,array));
	}
	
	/**
	 * ���룺
	 * 1,2,8,9
	 * 2,4,9,12
	 * 4,7,10,13
	 * 6,8,11,15
	 * ���裺
	 * 1����ʼ��indexRow = 0,indexColumn = columns - 1
	 * 2���������Ͻǵ�Ԫ�ؿ�ʼ�жϣ����array[indexRow][indexColumn]==n,ֱ�ӷ���true
	 * 3�����array[indexRow][indexColumn]>n,��˵����indexColumn�е�Ԫ��ȫ������n,
	 * ���indexColumn-1�н��Ų���,indexColumn=indexColumn-1
	 * 4�����array[indexRow][indexColumn]<n,��˵����indexRow�е�Ԫ��ȫ��С��n,
	 * ���indexRow+1�н��Ų���,indexRow=indexRow+1
	 */
	public boolean find(int n, int[][] array) {
		if (array != null && array.length > 0) {
			int rows = array.length;// ����
			int columns = array[0].length;// ����
			int indexRow = 0;
			int indexColumn = columns - 1;
			while (indexColumn >= 0 && indexRow < rows) {
				if (n < array[indexRow][indexColumn]) {
					indexColumn--;
				} else if (n > array[indexRow][indexColumn]) {
					indexRow++;
				} else {
					return true;
				}
			}
		}
		return false;
	}

}
