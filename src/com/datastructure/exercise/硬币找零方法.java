package com.datastructure.exercise;

/**
 * ������ m ����ֵ��ͬ��Ӳ�ң��洢�� coinsValues�����У�
 * ����Ҫʹ����ЩӲ������Ǯ������Ӳ�ҵ�ʹ�ø������ޡ� 
 * ����ڸ�����Ǯ��N����������м��ֲ�ͬ����Ǯ��ʽ��Ӳ�ҵ�˳�򲢲���Ҫ��
 */
public class Ӳ�����㷽�� {
	
	public static void main(String[] args) {
		int[] coinsValues = {5,20,10,2,3,1};
		int anim = 1000;
//		long res = solution1(coinsValues, 0, anim);
//		System.out.println(res);
		map = new long[coinsValues.length+1][anim+1];
		for(int i=0;i<coinsValues.length+1;i++){
			for(int j = 0;j<anim+1;j++){
				map[i][j] = -1;
			}
		}
		long res1 = solution2(coinsValues, 0, anim);
		System.out.println(res1);
		long res2 = solution3(coinsValues, anim);
		System.out.println(res2);
	}

	
	/**
	 * �����ݹ鷨����������ֵΪ[5,2,1],Ǯ������Ϊ1000�����ܵ���Ǯ���������·��������ܺͣ�
	 * 0��ȡ0��5Ԫ��ʣ���Ǯ��1000��[2,1]������Ǯ�ķ�����
	 * 1��ȡ1��5Ԫ��ʣ���Ǯ��995��[2,1]������Ǯ�ķ�����
	 * 2��ȡ2��5Ԫ��ʣ���Ǯ��990��[2,1]������Ǯ�ķ�����
	 * 3��ȡ3��5Ԫ��ʣ���Ǯ��985��[2,1]������Ǯ�ķ�����
	 * ......
	 * N��ȡ200��5Ԫ��ʣ���Ǯ��0��[2,1]������Ǯ�ķ�����
	 * 
	 * @param coinsValues �洢Ӳ�ҵ�����
	 * @param index coinsValues�е�����
	 * @param change ��Ҫ�ҵ�Ǯ��
	 */
	public static long solution1(int[] coinsValues, int index, int change) {
		long res = 0;// ��Ǯ�ķ�������
		if (index >= coinsValues.length) {
			res = change == 0 ? 1 : 0;// change=0
		} else {
			int curCoin = coinsValues[index];
			for (int i = 0; i * curCoin <= change; i++) {
				res += solution1(coinsValues, index + 1, change - i * curCoin);
			}
		}
		return res;
	}
	
	private static long[][] map;
	
	/**
	 * ��solution1���Ż�:���ֻ��index��change�����йأ�solution1���ڴ������ظ����㣬
	 * ����ʹ��һ����ά���鱣�����ֵ��map[index][change],map[i][j]ȡֵֻ��-1��0���������֣�
	 * -1��ʾsolution2(coinsValues, i, j)û�н��й����㣻0��ʾsolution2(coinsValues, i, j)
	 * ���й����㣬������ֵ��0��������ʾ���й������ҷ�����ֵ����0.
	 */
	public static long solution2(int[] coinsValues, int index, int change) {
		long res = 0;
		if (index >= coinsValues.length) {
			res = change == 0 ? 1 : 0;
		} else if (map[index][change] >= 0) {
			res = map[index][change];
		} else {
			int curCoin = coinsValues[index];
			for (int i = 0; i * curCoin <= change; i++) {
				map[index+1][change-i*curCoin] = solution2(coinsValues, index + 1, change-i*curCoin);
				res += map[index+1][change-i*curCoin];
			}
		}

		return res;
	}
	
	
	/**
	 * �����Ľ�solution2��c[i,j]��i��ʾ���õ�Ӳ��������j��ʾ��Ҫ�����Ǯ��
	 * c[i,j]=c[i-1,j]+c[i-1,j-coinsValues[i]];
	 * c[i-1,j]��ʾ��ʹ��iӲ�ҵķ�������c[i-1,j-coinsValues[i]]��ʾ����ʹ��һ��iӲ�ҵķ�����
	 * c[0,j]��ʾʹ��0��Ӳ�����j�ķ�����������c[0,j]=0;
	 * c[i,0]��ʾʹ��i��Ӳ�ң����0�ķ�������c[i,0]=1,���ǲ�ʹ�����Ӳ��
	 */
	public static long solution3(int[] coinsValues, int change) {
		long[][] c = new long[coinsValues.length + 1][change + 1];
		for (int i = 0; i <= coinsValues.length; i++) {
			c[i][0] = 1;
		}
		for (int i = 0; i <= change; i++) {
			c[0][i] = 0;
		}
		//���϶��£������ҿ�ʼ����
		for (int i = 1; i <= coinsValues.length; i++) {
			for (int j = 1; j <= change; j++) {
				int curCoin = coinsValues[i-1];//��i-1öӲ��
				if(j < curCoin){//��ǰӲ�Ҳ����ã���Ҫ��5��Ǯ��curCoinȴ��100��
					c[i][j] = c[i-1][j];
				}else{
					c[i][j] = c[i-1][j] + c[i][j-curCoin];
				}
			}
		}
		return c[coinsValues.length][change];
	}
	
	
}
