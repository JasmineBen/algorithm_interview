package com.datastructure.exercise;

public class StringExerice {

	/**
	 * �ж��ַ������е��ַ��Ƿ���Ψһ�ģ�Ҫ��ʱ�临�Ӷ�ΪO(N),�ռ临�Ӷ�ΪO(1)
	 * 1����ʹ�ö��������chars�е���������
	 */
	public static boolean isUnique(char[] chars){
		heapSort(chars);
		for(int i=0;i<chars.length-1;i++){
			if(chars[i+1] == chars[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ����һ����ȫ��������������У����еĸ��ڵ��ֵ���������ĺ��ӡ�������Ѱ��ղ�α����洢�������У�
	 * �����¹�ϵ��chars[i]>char[2i+1] && chars[i]>char[2i+2]
	 * @param chars
	 */
	public static void heapSort(char[] chars){
		//������һ������ѣ������������
		for(int i=chars.length/2-1;i>=0;i--){
			adjustHeap(chars, i, chars.length);
		}
		//����Ԫ�������һ���ڵ㽻����������ɺ���Ҫ���µ������Ԫ��֮ǰ�Ķѽṹ��ʵ�ִ�С���������
		for(int i=chars.length-1;i>=0;i--){
			char top = chars[i];
			chars[i] = chars[0];
			chars[0] = top;
			adjustHeap(chars, 0, i);
		}
	}
	
	//�����ѽṹ
	public static void adjustHeap(char[] chars,int i,int len){
		char temp = chars[i];
		for(int k=2*i+1;k<len;k=2*k+1){
			if(k+1<len && chars[k]<chars[k+1]){
				k++;
			}
			if(chars[k] > temp){//������k��i��k�������Ķ����Կ��ܷ����仯����Ҫ�������µ���
				chars[i] = chars[k];
				i = k;
			}else{
				break;
			}
		}
		chars[i] = temp;
	}
}
