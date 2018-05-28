package com.datastructure.exercise;

/**
 * 二维的整型数组满足以下条件：
 * a[i][j]<a[i][j+1]
 * a[i][j]<a[i+1][j];
 * 查找某个数是否在该数组里面
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
	 * 假设数组有n行，m列。从右上角开始查找
	 * 1、比较a[0][m-1],如果小于num说明要查找的数在a[0][m-1]的下方n-1行m列的数组中；
	 * 如果大于，说明要查找的数在a[0][m-1的左边，n行m-1列的矩阵中
	 * 2、循环查找即可
	 */
	public static boolean find(int[][] array,int num){
		int n = array.length-1;//行
		int m = array[0].length-1;//列
		int i = 0;
		while(i<= n && m >= 0){
			if(array[i][m] > num){//左边继续寻找
				m--;
			}else if(array[i][m] < num){//下边继续寻找
				i++;
			}else{
				return true;
			}
		}
		return false;
	}
}
