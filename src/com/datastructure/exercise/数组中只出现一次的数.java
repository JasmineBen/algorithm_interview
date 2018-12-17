package com.datastructure.exercise;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字
 *
 */
public class 数组中只出现一次的数 {
	
	public static void main(String[] args) {
		数组中只出现一次的数 test = new 数组中只出现一次的数();
		int[] a = {11,1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,10};
		test.FindNumsAppearOnce(a);
	}
	
	/*
	 * 异或运算交换律和结合律a^b^c=a^c^b=a^(b^c)
	 * 0异或任何数a的结果还是a
	 * 可以用位运算实现，如果将所有所有数字相异或，
	 * 则最后的结果肯定是那两个只出现一次的数字异或的结果
	 */
	public void FindNumsAppearOnce(int[] array) {
		if(array != null && array.length > 2){
			int e = 0;
			int f = 0;
			int temp = 0;
			//假设数组为aabbccddef,a^a^b^b^c^c^d^d^e^f = 0^e^f
			for(int i : array){
				temp ^= i;//0^0^e^f = 0^e^f = e^f
			}
			//找到最右边的1的index，index从0开始
			int indexOfOne = findFirstBitOne(temp);
			//temp的第indexOfOne低位为1，e f在indexOfOne肯定不同，假设e的indexOfOne为1，f的indexOfOne为0
			//所有indexOfOne位置为1的数据在一组，为0的第二组，这样就把e和f分为两组了
			for(int i : array){
				if(judgeIndexIsOne(indexOfOne, i)){//indexOfOne为1，
					e ^= i;
				}else{//indexOfOne为0
					f ^= i;
				}
			}
			System.out.println("e:"+e+";f:"+f);
		}
		
		
	}
	
	//判断n的第index位是否为1
	private boolean judgeIndexIsOne(int index,int n){
		return ((n >> index)&1) == 1;
	}

	//e和f相等，则e^f肯定有一位的二进制是1，找到最右边的1
	public int findFirstBitOne(int num) {
		int indexBit = 0;//num最多32位，int类型数在java内存中占32位
		while (((num & 1) == 0) && (indexBit) < 32) {
			num = num >> 1;
			++indexBit;
		}
		return indexBit;
	}
}
