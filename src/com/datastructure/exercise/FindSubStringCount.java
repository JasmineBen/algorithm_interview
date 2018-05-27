package com.datastructure.exercise;

import com.datastructure.basic.KMP;

/*
 * ��֪һ���ַ���������adsderwsde��Ѱ�����е�һ�����ַ�������sde�ĸ�����
 * ���û�оͷ���0���еĻ��������ַ����ĸ�����
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
	 * @param next kmp�㷨��next����
	 * @param startIndex ��һ�ο�ʼƥ����source�е�λ�ã���ʼֵΪ0
	 * ����һ��find���ҵ���һ��ƥ�䴮����source��ƥ�����λ��Ϊi-1���ǵڶ���ƥ��Ŀ�ʼλ��Ϊi-next[j].
	 * i��jʼ���ǲ�ѯ��ƥ�䴮�ĺ�һ��λ�ã�next[j]������0-��j-1�������ǰ��׺,�����´αȶԣ�ֻ��Ҫ��i��ǰ�ƶ�next[j]��λ��;
	 * ��Ϊ������next[j]=k,����pattern[0]-->pattern[k-1]=source[i-k]-->source[i-1];
	 * ��һ��ƥ��ֱ�Ӵ� source[i-k]��ʼ����
	 * */
	public static void find(int[] next,int startIndex,String source,String pattern){
		System.out.println("startIndex:"+startIndex);
		int i = startIndex;
		int j = 0;
		while(i < source.length()&&j<pattern.length()){
			//j=-1,pattern��ͷ��ʼ�ȶ�
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
