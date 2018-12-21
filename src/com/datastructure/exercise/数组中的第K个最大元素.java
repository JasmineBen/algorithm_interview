package com.datastructure.exercise;

/**
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ��
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 *
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 */
public class �����еĵ�K�����Ԫ�� {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(new �����еĵ�K�����Ԫ��().findKthLargest(nums, 2));
	}

	/**
	 * ���ŵ�partition�ı���
	 */
	public int findKthLargest(int[] nums, int k) {
		if(nums != null && nums.length > 0 && k > 0 && k <= nums.length) {
			k--;
			int start = 0;
			int end = nums.length - 1;
			while(true) {
				int partition = partition(nums, start, end);
				if(partition == k) {
					return nums[partition];
				}else if(partition < k){
					start = partition + 1;
				}else {
					end = partition - 1;
				}
			}
		}
        return 0;
    }
	
	
	private int partition(int[] a, int start, int end) {
		int key = a[start];
		while (start < end) {//ɨ��˳���ܴ�
			while(a[end] <= key && start < end){//�Ӻ���ǰɨ��
				end -- ;
			}
			a[start] = a[end];
			
			while(a[start] >= key && start < end){//��ǰ����ɨ��
				start ++;
			}
			a[end] = a[start];			
		}
		a[end] = key;
		return end;
	}
}
