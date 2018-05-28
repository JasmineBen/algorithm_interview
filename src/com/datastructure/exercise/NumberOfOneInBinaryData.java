package com.datastructure.exercise;

/**
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。 补码：负数绝对值的二进制表示，每位取反，最后再加1
 * int类型在java中使用32位二进制表示
 * -10: 11111111111111111111111111110110
 */
public class NumberOfOneInBinaryData {

	public static void main(String[] args) {
		NumberOfOneInBinaryData test = new NumberOfOneInBinaryData();
		// for (int i = 0; i < 10; i++) {
		System.out.println(test.niceNumberOf1(-10));
		// }
	}

	/**
	 * 与运算，同时为1&1=1，1&0=0，0&1=0，0&0=0 每次将1左移一位，再做与运算，判断当前位是否为1
	 */
	public int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	/**
	 * 最优解：
	 * 如果一个整数不等于0，那么该整数中的二进制数至少有一个是1，
	 * 假设最低位为1，那么在减去1后，最低位变成0，其余位置不变。相当于对最低位进行了取反操作。
	 * 假设最后一位不是1而是0的情况，如果该二进制最右边的1位于第m位，那么减去1，第m位变为0，第m位之后全部变成1，第m位前面的所有位保持不变。
	 * 例如1100-1=1011，减去1后第二位变成0，后面的变成1，前面的不变。
	 * 我们发现，一个数减去1是把最右边的1变成0，把他右边的数变成1，左边的保持不变，
	 * 把n和n-1做与运算，相当于把n的最右边的1和1右边的所有数据变成0，也就是说有多少个1，就需要做多少次与运算：
	 * n&(n-1)=n1将最右边的1变成0,计算出1个1；n1&(n1-1)将n1右边的1变成0，当最后结果为0时，统计结束
	 * 
	 */
	public int niceNumberOf1(int n) {
		int count = 0;
		while(n != 0){//n不等于0，至少1个1
			count ++;
			n = (n&(n-1));//去掉n最右边的1
		}
		return count;
	}
}
