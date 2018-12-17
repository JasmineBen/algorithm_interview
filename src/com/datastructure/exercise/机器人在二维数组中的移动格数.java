package com.datastructure.exercise;

/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
 * ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *  ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 *  ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 *
 */
public class �������ڶ�ά�����е��ƶ����� {
	
	public static void main(String[] args) {
		�������ڶ�ά�����е��ƶ����� test = new �������ڶ�ά�����е��ƶ�����();
		System.out.println(test.movingCount(5,10,10));
	}
	
	private int mCount = 0;
	public int movingCount(int threshold, int rows, int cols) {
		if(threshold < 0 || rows < 0 || cols < 0 || (rows == 0&& cols == 0)){
			return 0;
		}
		return moving(threshold,rows,cols,0,0,new boolean[rows * cols]);
	}
	
	public int moving(int threshold, int rows, int cols, int i, int j, boolean[] checking) {
		int checkIndex = cols * i + j;
		if (i < 0 || j < 0 || i >= rows || j >= cols || checking[checkIndex]) {
			return 0;
		}
		checking[checkIndex] = true;
		if (checkSum(i, j, threshold)) {
			System.out.println(i + " " + j);
			mCount = 1 + moving(threshold, rows, cols, i - 1, j, checking)
					+ moving(threshold, rows, cols, i + 1, j, checking)
					+ moving(threshold, rows, cols, i, j - 1, checking)
					+ moving(threshold, rows, cols, i, j + 1, checking);
		} else {
			mCount = moving(threshold, rows, cols, i - 1, j, checking)
					+ moving(threshold, rows, cols, i, j - 1, checking);
		}

		return mCount;

	}
	
	private boolean checkSum(int i,int j,int threshold){
		String s1 = String.valueOf(i);
		String s2 = String.valueOf(j);
		int sum = 0;
		int zero = '0';
		for(int a = 0;a < s1.length();a++){
			sum += (s1.charAt(a) - zero);
		}
		for(int a = 0;a < s2.length();a++){
			sum += (s2.charAt(a) - zero);
		}
		return sum <= threshold;
				
	}
}
