package com.datastructure.exercise;

/**
 * ��ά������������������������
 * a[i][j]<a[i][j+1]
 * a[i][j]<a[i+1][j];
 * ����ĳ�����Ƿ��ڸ���������
 *
 */
public class FindInTwoDimensionalArray {

	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15},{
			7,12,17,18
		}};
		System.out.println(find(a, 14));
		System.out.println(find(a, 17));
	}
	
	/**
	 * ����������n�У�m�С������Ͻǿ�ʼ����
	 * 1���Ƚ�a[0][m-1],���С��num˵��Ҫ���ҵ�����a[0][m-1]���·�n-1��m�е������У�
	 * ������ڣ�˵��Ҫ���ҵ�����a[0][m-1����ߣ�n��m-1�еľ�����
	 * 2��ѭ�����Ҽ���
	 */
	public static boolean find(int[][] array,int num){
		int n = array.length-1;//��
		int m = array[0].length-1;//��
		int i = 0;
		while(i<= n && m >= 0){
			if(array[i][m] > num){//��߼���Ѱ��
				m--;
			}else if(array[i][m] < num){//�±߼���Ѱ��
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
}
