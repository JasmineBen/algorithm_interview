package com.datastructure.basic;

/**
 * 
 * KMP算法
 *
 */
public class KMP {
	
	public static void main(String[] args) {
		int index = find("abababababcaaba","abababca");
		System.out.println(index);
	}

	/**
	 * 主串S,模式串pattern (abababca)
	 * 1、先计算next数组
	 * PMT数组：PMT[j]表示以pattern[j]结尾的的子模式串，所有前缀和所有后缀的交集里面的最长子串的长度:
	 * pattern  a  b  a  b  a  b  c  a
	 * index(j) 0  1  2  3  4  5  6  7
	 * PMT[j]   0  0  1  2  3  4  0  1
	 * 例：ababab的前缀子串为{a,ab,aba,abab,ababa},后缀子串为{b,ab,bab,abab,babab};
	 * 两者的交集为{ab,abab},最长交集为abab,长度为4，所以PMT[5]=4。
	 * 在进行模式匹配时，假设在pattern[j]处匹配失败了，此时主串S的index指向i，
	 * 说明主串S[i-j,i-1]的位置和模式串pattern[0,j-1]是匹配成功的。
	 * 即S[i-j,i-1]=pattern[0,j-1]， 假设PMT[j-1]=k，说明模式串pattern[0,k-1]=pattern[j-k,j-1]，
	 * 继续匹配时，只需要将模式串的j指向k(PMT[j-1])即可，保证了S[i-k,i-1]=pattern[0,k-1]
	 * 
	 * next数组是在PMT基础上建立的，是将PMT数组向右移了一位，并将next[0]设置为-1，这样在模式匹配时，当模式串的第j位不匹配时，
	 * 将模式串的当前索引j指向next[j]即可：
	 * pattern  a  b  a  b  a  b  c  a
	 * index(j) 0  1  2  3  4  5  6  7
	 * PMT[j]   0  0  1  2  3  4  0  1
	 * next[j] -1  0  0  1  2  3  4  0  1
	 * 
	 * 2、根据next数组匹配
	 */
	public static int find(String s,String pattern){
		int[] next = next(pattern);//计算next数组
		int i = 0;//主串的index
		int j = 0;//模式串的index
		while(i < s.length() && j < pattern.length()){
			if(s.charAt(i) == pattern.charAt(j)){
				//当前字符匹配，主串和模式串同时移动一位
				i++;
				j++;
			}else{
				//当前字符串不匹配，模式串指向next[j]
				j = next[j];
			}
		}
		//匹配完成后模式串指向结尾
		if(j == pattern.length()){
			return i-j;
		}
		return -1;
	}
	
	
	
	/**
	 * 计算next数组， pattern为模式串(abababca)
	 * 求next数组的过程也可以看做模式匹配的过程，此时pattern作为主串，pattern的前缀作为模式串。
	 * 相当于拿pattern[0,i]的后缀子串和pattern[0,j]的前缀子串进行对比
	 * 计算从pattern[1]开始，next[0]=-1。
	 * pattern主串    a  b  a  b  a  b  c  a
	 * pattern前缀             a  b  a  b  a  b  c  a
	 * 
	 */
	public static int[] next(String pattern){
		int[] next = new int[pattern.length()+1];
		next[0] = -1;
		int i = 0;
		int j = -1;//指向以i结尾的，j<i,j是前缀部分的结尾
		while(i<pattern.length()){
			if(j == -1){
				i++;
				j++;
				next[i] = j;
			}else if(pattern.charAt(i) == pattern.charAt(j)){
				//pattern[i-j,i]的后缀和pattern[0,j]的前缀一样
				i++;
				j++;
				next[i] = j;
			}else{
				//前缀pattern[i]和后缀pattern[j]指向的字符不一致，next[j]=PMT[j-1]=k,
				//此时pattern[i-k,i-1]中pattern[0,k-1]是相等的，所以设置j=k(PMT[j-1]/next[j])
				//调整后只有两种情况，j=-1或者pattern[i]=pattern[j]
				j = next[j];
			}
		}
		return next;
	}
}
