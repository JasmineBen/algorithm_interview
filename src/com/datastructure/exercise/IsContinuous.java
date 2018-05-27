package com.datastructure.exercise;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
 * ������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),
 * ��So Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 *
 */
public class IsContinuous {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,2,5,4};
		System.out.println(isContinuous(a));
	}

	/**
	 * �������������С���Ĳ�ܳ���4
	 * ��β����з�0���ظ�����
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
			//����numbers[i+1]λ�����numbers[i]=numbers[i+1]����3�ƺ�ֵΪ1
			if(((rotateNum >> numbers[i])&1) == 1){
				System.out.println("x");
				return false;
			}
			rotateNum = 1 << numbers[i];//����numbers[i]λ
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
