package com.datastructure.basic;

/**
 * 
 * KMP算法
 *
 */
public class KMP {
	
	public static void main(String[] args) {
		find("abcd","abab");
	}

	public static int find(String source,String pattern){
		int[] next = next(pattern);
//		for(int i: next){
//			System.out.print(i+";");
//		}
		int i = 0;
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
//		System.out.println("i:"+i+";j:"+j);
		return i-j;
	}
	
	
	
	/**
	 * 计算next数组
	 * @param pattern 模式串
	 * @return
	 */
	public static int[] next(String pattern){
		int[] next = new int[pattern.length()+1];
		int k = -1;
		int j = 0;
		next[0] = -1;
		while(j < pattern.length()){
			System.out.println("k:"+k+";j:"+j);
			if(k == -1 || pattern.charAt(k) == pattern.charAt(j)){
				next[++j] = ++k;
			}else{
				k = next[k];
			}
		}
		return next;
	}
}
