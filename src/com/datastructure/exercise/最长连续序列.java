package com.datastructure.exercise;

import java.util.HashSet;

/**
 * ����һ��δ������������飬�ҳ���������еĳ��ȡ�
 * Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��
 * ����: [100, 4, 200, 1, 3, 2]
 * ���: 4
 * ����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 *
 */
public class ��������� {
	
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new ���������().longestConsecutive(nums));
	}

	/**
	 * 1�������е�������HashSet����ʱHaseSet�洢�������в�ͬ������
	 * 2����������num[i]��pre=num[i]-1,next=num[i]+1,ѭ����ѯpre--��next--��ֱ����ѯʧ�ܣ�
	 * �Ľ��Ϊnext-pre-1
	 * 3����ÿһ�α�������������num[i]���������ڵ�����ȫ����ɾ���ˣ��������������໹������HashSet�е�Ԫ�أ�������ͬ��
	 * ���ս��Ϊnext-pre-1�е����ֵ
	 */
	public int longestConsecutive(int[] nums) {
		int res = 0;
		if(nums != null && nums.length > 0) {
			HashSet<Integer> set = new HashSet<>();
			for(int i : nums) {
				set.add(i);
			}
			for(int i : nums) {
				if(set.remove(i)) {
					int pre = i-1;
					int next = i+1;
					while(set.remove(pre)) {
						pre--;
					}
					while(set.remove(next)) {
						next ++;
					}
					res = Math.max(next-pre-1, res);
				}
			}
		}
        return res;
    }
}
