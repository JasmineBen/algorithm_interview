package com.datastructure.exercise;

/**
 * ����һ�����ӳ���Ϊn(n>1)������m(m>1)�Σ�ÿ�γ��ȶ�������
 * ��������˳���Ϊk[0],k[1],...k[m-1]�Σ�����μ�����ʹ��k[0]*k[1]*..k[m-1]���
 */
public class ������ʹ��ÿһ�εĳ˻���� {
	
	public static void main(String[] args) {
		System.out.println(solution(8));
	}

	
	/**
	 * ���庯��f(n)Ϊ�ѳ���Ϊn�����Ӽ������ɶ�֮��ĳ˻����ֵ���ڼ���һ����ʱ����n-1��ѡ��
	 * Ҳ���Ǽ����������ӿ��ܳ���Ϊ1,2,3...n-1�����f(n)=max(f(i)*f(n-i))
	 */
	public static int solution(int n){
		if(n<2){
			return 0;
		}
		if(n==2){
			return 1;
		}
		if(n==3){
			return 2;
		}
		int[] product = new int[n+1];//ʣ�೤�ȵ������ܹ�����������ֵ
		product[0]=0;
		product[1]=1;
		product[2]=2;
		product[3]=3;
		for(int i=4;i<=n;i++){
			int max = 0;
			for(int j=1;j<=i/2;j++){
				if(product[j]*product[i-j]>max){
					max = product[j]*product[i-j];
				}
			}
			product[i] = max;
		}
		return product[n];
	}
}
