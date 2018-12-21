package com.datastructure.exercise;

/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
 * ע���㲻���������Ʊǰ������Ʊ��
 * ����: [7,1,5,3,6,4]
 * ���: 5
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 * ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 *
 */
public class ������Ʊ�����ʱ�� {
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	/**
	 * ����ؼ������ֻ�������һ�������һ��������Ҳ����ֻ����һ�Σ�ֻ����һ�Ρ�
	 * ����ǰ��������ÿ���ҵ��Ѿ�������������Сֵ��Ȼ������ҵ�prices[i]-min�����ֵ
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int max = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (max < prices[i] - min) {
				max = prices[i] - min;
			}
		}
		return max;
	}
}
