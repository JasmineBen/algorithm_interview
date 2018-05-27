package com.datastructure.exercise;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 *
 */
public class IsContinuous {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,2,5,4};
		System.out.println(isContinuous(a));
	}

	/**
	 * 首先最大数和最小数的差不能超过4
	 * 其次不能有非0的重复数字
	 * @param numbers
	 * @return
	 */
	public static boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5 ){
			return false;
		}
		int max = -1;
		int min = 14;
		int rotateNum = 0;
		for(int i = 0;i<numbers.length;i++){
			if(numbers[i] > 13 || numbers[i] < 0){
				return false;
			}
			if(numbers[i] == 0){
				continue;
			}
			//右移numbers[i+1]位，如果numbers[i]=numbers[i+1]，则3移后值为1
			if(((rotateNum >> numbers[i])&1) == 1){
				System.out.println("x");
				return false;
			}
			rotateNum = 1 << numbers[i];//左移numbers[i]位
			if(numbers[i] > max){
				max = numbers[i];
			}
			if(numbers[i] < min){
				min = numbers[i];
			}
			System.out.println("max:"+max+";min:"+min);
			if(max - min > 4){
				return false;
			}
		}
		return true;
    }
}
