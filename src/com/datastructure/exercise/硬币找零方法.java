package com.datastructure.exercise;

/**
 * 假设有 m 种面值不同的硬币，存储在 coinsValues数组中，
 * 现需要使用这些硬币来找钱，各种硬币的使用个数不限。 
 * 求对于给定的钱数N，我们最多有几种不同的找钱方式。硬币的顺序并不重要。
 */
public class 硬币找零方法 {
	
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
	 * 暴力递归法，假设数组值为[5,2,1],钱的总数为1000，则总的找钱方法数如下方法数的总和：
	 * 0、取0个5元，剩余的钱数1000用[2,1]数组找钱的方法数
	 * 1、取1个5元，剩余的钱数995用[2,1]数组找钱的方法数
	 * 2、取2个5元，剩余的钱数990用[2,1]数组找钱的方法数
	 * 3、取3个5元，剩余的钱数985用[2,1]数组找钱的方法数
	 * ......
	 * N、取200个5元，剩余的钱数0用[2,1]数组找钱的方法数
	 * 
	 * @param coinsValues 存储硬币的数组
	 * @param index coinsValues中的索引
	 * @param change 需要找的钱数
	 */
	public static long solution1(int[] coinsValues, int index, int change) {
		long res = 0;// 找钱的方法总数
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
	 * 对solution1的优化:结果只与index和change属性有关，solution1存在大量的重复计算，
	 * 可以使用一个二维数组保存计算值，map[index][change],map[i][j]取值只有-1，0，正数三种；
	 * -1表示solution2(coinsValues, i, j)没有进行过计算；0表示solution2(coinsValues, i, j)
	 * 进行过计算，但返回值是0；正数表示进行过计算且返回了值大于0.
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
	 * 继续改进solution2，c[i,j]，i表示可用的硬币类数，j表示需要找零的钱数
	 * c[i,j]=c[i-1,j]+c[i-1,j-coinsValues[i]];
	 * c[i-1,j]表示不使用i硬币的方法数，c[i-1,j-coinsValues[i]]表示至少使用一个i硬币的方法数
	 * c[0,j]表示使用0类硬币组成j的方法数，所以c[0,j]=0;
	 * c[i,0]表示使用i类硬币，组成0的方法数，c[i,0]=1,就是不使用这个硬币
	 */
	public static long solution3(int[] coinsValues, int change) {
		long[][] c = new long[coinsValues.length + 1][change + 1];
		for (int i = 0; i <= coinsValues.length; i++) {
			c[i][0] = 1;
		}
		for (int i = 0; i <= change; i++) {
			c[0][i] = 0;
		}
		//从上而下，从左到右开始计算
		for (int i = 1; i <= coinsValues.length; i++) {
			for (int j = 1; j <= change; j++) {
				int curCoin = coinsValues[i-1];//第i-1枚硬币
				if(j < curCoin){//当前硬币不可用，需要找5块钱，curCoin却是100的
					c[i][j] = c[i-1][j];
				}else{
					c[i][j] = c[i-1][j] + c[i][j-curCoin];
				}
			}
		}
		return c[coinsValues.length][change];
	}
	
	
}
