package com.datastructure.exercise;

import com.datastructure.basic.KMP;

/*
 * 已知一个字符串，比如adsderwsde，寻找其中的一个子字符串比如sde的个数，
 * 如果没有就返回0，有的话返回子字符串的个数。
 */
public class FindSubStringCount {
	
	public static int num = 0;
	
	public static void main(String[] args) {
		String source = "aabaerabaeaba";
		String pattern = "aba";
		find(KMP.next( pattern),0, source, pattern);
		System.out.println("num:"+num);
	}
	
	/**
	 * @param next kmp算法的next数组
	 * @param startIndex 下一次开始匹配在source中的位置，初始值为0
	 * 假设一次find后找到第一个匹配串的在source的匹配结束位置为i-1，那第二次匹配的开始位置为i-next[j].
	 * i和j始终是查询到匹配串的后一个位置，next[j]，就是0-（j-1）的最大前后缀,这样下次比对，只需要将i向前移动next[j]的位置;
	 * 因为：假设next[j]=k,所以pattern[0]-->pattern[k-1]=source[i-k]-->source[i-1];
	 * 下一次匹配直接从 source[i-k]开始即可
	 * */
	public static void find(int[] next,int startIndex,String source,String pattern){
		System.out.println("startIndex:"+startIndex);
		int i = startIndex;
		int j = 0;
		while(i < source.length()&&j<pattern.length()){
			//j=-1,pattern从头开始比对
			if(j==-1||source.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j== pattern.length() && i-j >= 0){
			num ++;
			System.out.println("i:"+i+";j:"+j+";next:"+next[j-1]);
			find(next,i-next[j],source, pattern);
		}
		
	}

	
}
