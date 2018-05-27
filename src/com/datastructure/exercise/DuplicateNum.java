package com.datastructure.exercise;

/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * @author admin
 *
 */
public class DuplicateNum {

	//��һ�����ֱ����ʹ��󣬿������ö�Ӧλ�ϵ��� + n��֮����������ͬ����ʱ��
	//�ᷢ�ֶ�Ӧλ�ϵ����Ѿ����ڵ���n�ˣ���ôֱ�ӷ�����������ɡ�
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(numbers == null || numbers.length == 0 || numbers.length != length){
	    	return false;
	    }
	    for(int i = 0;i< length;i++){
	    	if(numbers[i] >= length){
	    		if(numbers[numbers[i] - length] > length){
	    			duplication[0] = numbers[i] - length;
	    			return true;
	    		}
	    		numbers[numbers[i] - length] = numbers[numbers[i]-length] + length;
	    	}else{
	    		numbers[numbers[i]] = numbers[numbers[i]] + length;
	    	}
	    }
	    return false;
    }
}
