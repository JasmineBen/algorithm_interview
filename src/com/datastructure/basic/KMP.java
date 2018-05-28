package com.datastructure.basic;

/**
 * 
 * KMP�㷨
 *
 */
public class KMP {
	
	public static void main(String[] args) {
		int index = find("abababababcaaba","abababca");
		System.out.println(index);
	}

	/**
	 * ����S,ģʽ��pattern (abababca)
	 * 1���ȼ���next����
	 * PMT���飺PMT[j]��ʾ��pattern[j]��β�ĵ���ģʽ��������ǰ׺�����к�׺�Ľ����������Ӵ��ĳ���:
	 * pattern  a  b  a  b  a  b  c  a
	 * index(j) 0  1  2  3  4  5  6  7
	 * PMT[j]   0  0  1  2  3  4  0  1
	 * ����ababab��ǰ׺�Ӵ�Ϊ{a,ab,aba,abab,ababa},��׺�Ӵ�Ϊ{b,ab,bab,abab,babab};
	 * ���ߵĽ���Ϊ{ab,abab},�����Ϊabab,����Ϊ4������PMT[5]=4��
	 * �ڽ���ģʽƥ��ʱ��������pattern[j]��ƥ��ʧ���ˣ���ʱ����S��indexָ��i��
	 * ˵������S[i-j,i-1]��λ�ú�ģʽ��pattern[0,j-1]��ƥ��ɹ��ġ�
	 * ��S[i-j,i-1]=pattern[0,j-1]�� ����PMT[j-1]=k��˵��ģʽ��pattern[0,k-1]=pattern[j-k,j-1]��
	 * ����ƥ��ʱ��ֻ��Ҫ��ģʽ����jָ��k(PMT[j-1])���ɣ���֤��S[i-k,i-1]=pattern[0,k-1]
	 * 
	 * next��������PMT�����Ͻ����ģ��ǽ�PMT������������һλ������next[0]����Ϊ-1��������ģʽƥ��ʱ����ģʽ���ĵ�jλ��ƥ��ʱ��
	 * ��ģʽ���ĵ�ǰ����jָ��next[j]���ɣ�
	 * pattern  a  b  a  b  a  b  c  a
	 * index(j) 0  1  2  3  4  5  6  7
	 * PMT[j]   0  0  1  2  3  4  0  1
	 * next[j] -1  0  0  1  2  3  4  0  1
	 * 
	 * 2������next����ƥ��
	 */
	public static int find(String s,String pattern){
		int[] next = next(pattern);//����next����
		int i = 0;//������index
		int j = 0;//ģʽ����index
		while(i < s.length() && j < pattern.length()){
			if(s.charAt(i) == pattern.charAt(j)){
				//��ǰ�ַ�ƥ�䣬������ģʽ��ͬʱ�ƶ�һλ
				i++;
				j++;
			}else{
				//��ǰ�ַ�����ƥ�䣬ģʽ��ָ��next[j]
				j = next[j];
			}
		}
		//ƥ����ɺ�ģʽ��ָ���β
		if(j == pattern.length()){
			return i-j;
		}
		return -1;
	}
	
	
	
	/**
	 * ����next���飬 patternΪģʽ��(abababca)
	 * ��next����Ĺ���Ҳ���Կ���ģʽƥ��Ĺ��̣���ʱpattern��Ϊ������pattern��ǰ׺��Ϊģʽ����
	 * �൱����pattern[0,i]�ĺ�׺�Ӵ���pattern[0,j]��ǰ׺�Ӵ����жԱ�
	 * �����pattern[1]��ʼ��next[0]=-1��
	 * pattern����    a  b  a  b  a  b  c  a
	 * patternǰ׺             a  b  a  b  a  b  c  a
	 * 
	 */
	public static int[] next(String pattern){
		int[] next = new int[pattern.length()+1];
		next[0] = -1;
		int i = 0;
		int j = -1;//ָ����i��β�ģ�j<i,j��ǰ׺���ֵĽ�β
		while(i<pattern.length()){
			if(j == -1){
				i++;
				j++;
				next[i] = j;
			}else if(pattern.charAt(i) == pattern.charAt(j)){
				//pattern[i-j,i]�ĺ�׺��pattern[0,j]��ǰ׺һ��
				i++;
				j++;
				next[i] = j;
			}else{
				//ǰ׺pattern[i]�ͺ�׺pattern[j]ָ����ַ���һ�£�next[j]=PMT[j-1]=k,
				//��ʱpattern[i-k,i-1]��pattern[0,k-1]����ȵģ���������j=k(PMT[j-1]/next[j])
				//������ֻ�����������j=-1����pattern[i]=pattern[j]
				j = next[j];
			}
		}
		return next;
	}
}
