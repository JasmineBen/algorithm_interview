package com.datastructure.exercise;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� 
 * ���� 
 * a b c e 
 * s f c s 
 * a d e e 
 * �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 *
 */
public class �жϾ����Ƿ����ĳ���ַ�����·�� {
	
	public static void main(String[] args) {
		char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
		char[] path = new char[]{'b','c','c','e','d'};
		char[] path1 = new char[]{'a','b','c','b'};
		�жϾ����Ƿ����ĳ���ַ�����·�� test =  new �жϾ����Ƿ����ĳ���ַ�����·��();
		System.out.println(test.hasPath(matrix, 3, 4, path1));
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix != null && str != null && matrix.length > 0 && str.length >0){
			
			for(int i = 0;i< rows;i++){
				for(int j = 0;j<cols;j++){//ÿ���㶼������Ϊ���
					boolean[] checking = new boolean[rows * cols];
					if(hasPath(matrix, rows, cols, i,j,str,0,checking)){
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param matrix 
	 * @param rows ����
	 * @param cols ����
	 * @param i �к�
	 * @param j �к�
	 * @param str �����·��
	 * @param k �����·����index
	 * @param flag
	 * @return
	 */
	private boolean hasPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] checking) {
		int checkIndex = i * cols + j;//��ά���鿴��һά���飬�����н���ƽ�� 
		if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[checkIndex] != str[k] || checking[checkIndex]){
			return false;
		}
		if(k == str.length - 1){
			return true;
		}
		checking[checkIndex] = true;//������ڼ�鵱ǰλ��
		if(hasPath(matrix,rows,cols,i-1,j,str,k+1,checking) 
				|| hasPath(matrix, rows, cols, i+1, j, str, k+1, checking)
				||hasPath(matrix, rows, cols, i, j-1, str, k+1, checking)
				||hasPath(matrix, rows, cols, i, j+1, str, k+1, checking)){
			return true;
		}
		checking[checkIndex] = false;//û���ҵ�·������ǰλ������Ϊδ���ʹ�
		return false;
	}
}
