package com.datastructure.exercise;

/**
 * ��һ����·���� N ������վ�����е� i ������վ������ gas[i] ����
 * ����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�
 * ���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��
 * ˵��: �����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
 * ���������Ϊ�ǿ����飬�ҳ�����ͬ��
 * ���������е�Ԫ�ؾ�Ϊ�Ǹ�����
 * ʾ�� 1:
 * ����: 
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * ���: 3
 * ����:
 * �� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
 * ���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
 * ���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
 * ���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
 * ���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
 * ���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
 * ��ˣ�3 ��Ϊ��ʼ������
 * 
 * ʾ�� 2:
 * ����: 
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * ���: -1
 *	����:
 *	�㲻�ܴ� 0 �Ż� 1 �ż���վ��������Ϊû���㹻�����Ϳ���������ʻ����һ������վ��
 *	���Ǵ� 2 �ż���վ���������Ի�� 4 �����͡� ��ʱ������ = 0 + 4 = 4 ������
 *	���� 0 �ż���վ����ʱ������ 4 - 3 + 2 = 3 ������
 *	���� 1 �ż���վ����ʱ������ 3 - 3 + 3 = 3 ������
 *	���޷����� 2 �ż���վ����Ϊ������Ҫ���� 4 �����ͣ������������ֻ�� 3 �����͡�
 *	��ˣ������������㶼�������ƻ�·��ʻһ�ܡ�
 *
 */
public class ����վ {
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(new ����վ().canCompleteCircuit(gas, cost));
	}

	 public int canCompleteCircuit(int[] gas, int[] cost) { 
		if (gas != null && cost != null && gas.length == cost.length && gas.length > 0) {
			for(int i = 0;i<gas.length;i++) {
				if(gas[i] >= cost[i]) {
					int index = canCompleteCircuitFormStart(gas, cost,i);
					if(index != -1) {
						return index;
					}
				}
			}
		}
		return -1;
	 }
	 
	 private int canCompleteCircuitFormStart(int[] gas, int[] cost,int start) {
		 int left = 0;
		 for(int i = start;i<gas.length;i++) {
			 if(left >= 0) {
				 left += (gas[i] - cost[i]);
			 }else {
				 return -1;
			 }
		 }
		 for(int i = 0;i<start;i++) {
			 if(left >= 0) {
				 left += (gas[i] - cost[i]);
			 }else {
				 return -1;
			 }
		 }
		 return left >=0 ? start : -1;
	 }
}
