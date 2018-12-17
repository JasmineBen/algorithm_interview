package com.datastructure.exercise;

/**
 * 斐波那契数列 f(0) = 0,f(1)=1,f(2)=1,f(3)=2,f(n)=f(n-1)+f(n-2)
 */
public class 斐波那契数列 {

	public static void main(String[] args) {
		斐波那契数列 f = new 斐波那契数列();
		System.out.println(f.fibonacci(39));
	}

	/**
	 * 输入一个整数n，斐波那契数列的第n项。n<=39 1、使用x保存f(n-2),y保存f(n-1) 2、初始值x=f(0)=0,y=f(1)=1
	 * 3、计算f(2)=f(1)+f(0)=x+y 4、计算完成后y=f(2)=x+y,x=f(1)=x+y-x
	 */
	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if(n==1 || n ==2){
			return 1;
		}
		int f2 = 1;// f(n-2)
		int f1 = 1;// f(n-1)
		// 依次计算f(3)...f(n)
		for (int i = 3; i <= n; i++) {
			int tmp = f1;
			f1 = f1 + f2;
			f2 = tmp;
		}
		return f1;
	}

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。 求该青蛙跳上一个n级的台阶总共有多少种跳法 1、假设有f(n)种跳法
	 * 2、第一步跳一个台阶，则有f(n-1)种解法，第一步跳2个台阶有f(n-1)中跳法
	 * 3、由于第一步只能挑一级或者两级，所以f(n)=f(n-1)+f(n-2) 4、f(0)=1,f(1)=1,f(2)=2;f(3)=3
	 */
	public int jumpFloor(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int f2 = 1;// f(n-2),n=1
		int f1 = 2;// f(n-1),n=2
		// 依次计算f(3)...f(n)
		for (int i = 3; i <= n; i++) {
			int tmp = f1;
			f1 = f1 + f2;//新的f(n-1)
			f2 = tmp;//新的f(n-2)
		}
		return f1;
	}

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 1、假设有f(n)种跳法
	 * 2、第一次跳一个台阶的跳法为f(n-1),第一次跳两个台阶的跳法为f(n-2),
	 * 第一次跳三个台阶，剩余台阶的跳法为f(n-3)，第一次跳n-1个台阶剩余台阶跳法为f(n-(n-1))
	 * 第一次跳n个台阶，剩余台阶的跳法为f(n-n)=1
	 * 3、f(n)为第二步中所有场景之和，f(n)=f(n-1)+f(n-2)...+f(0)
	 * 4、替换n=n-1,则f(n-1)=f(n-2)+f(n-3)+...+f(0)
	 * 5、将第四步的函数替换到第二步，得到f(n)=2*f(n-1)
	 * 6、f(2)=2*1=2,f(3)=4,f(4)=8
	 */
	public int jumpFloorII(int target) {
		return 1<<(target-1);//1左移(target-1)位
	}
	
	/**
	 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 1、假设有f(n)中方法,n为列坐标，有n个矩阵
	 * 2、第一个矩形如果竖着放，即消耗了第一列剩余的矩阵的解法为f(n-1)
	 * 3、第一个矩形如果横着放，剩余的矩阵的解法为f(n-2),
	 * 因为如果第一个矩阵横着放，它的下方也必须横着放一个矩阵，方式已经固定
	 * 4、f(0)=0,f(1)=1,f(2)=2,f(3)=3,f(n)=f(n-1)+f(n-2)
	 * 
	 */
	public int rectCover(int n) {
		if (n == 0 ) {
			return 0;
		}
		if (n == 1 ) {
			return 1;
		}
		int x = 1;// f(0)
		int y = 1;// f(1)
		// 依次计算f(2),f(3)...f(n)
		for (int i = 1; i < n; i++) {
			y = x + y;// f(n)
			x = y - x;// f(n-1)
		}
		return y;
    }
}
