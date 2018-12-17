package com.datastructure.exercise;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 */
public class 查询数组的重复数字 {
	
	public static void main(String[] args) {
		int[] a = {2,3,1,0,2,5,3};
		int res = duplicate(a);
		System.out.println(res);
	}

	/**
	 * 对于数组a，如果没有重复数字，那么在从小到大排序后，a[i]=i
	 * 我们可以模拟排序的过程，i从0开始，
	 * 1、if a[i]=i,i++;
	 * 2、if a[i]!=i，比较a[a[i]]和a[i]，即比较a[i]本来应该位于的位置上是否已经存在相同的数据
	 *   2.1、 a[a[i]]=a[i]，a[i]就是相同的数据，返回即可
	 *   2.2、 a[a[i]]!=a[i],将a[i]保存到本身应该存放的位置，即交换a[a[i]]和a[i]，交换完成后i的数值不能变，需要做i--
	 */
	public static int duplicate(int a[]) {
		for(int i = 0;i<a.length;i++){
			if(a[i]==i){//是已经排序的
				continue;
			}else{
				if(a[a[i]] == a[i]){//找到了重复数据
					return a[i];
				}else{
					int tmp = a[i];
					a[i] = a[a[i]];
					a[tmp] = tmp;
					i--;
				}
			}
		}
		return -1;
	}
}
