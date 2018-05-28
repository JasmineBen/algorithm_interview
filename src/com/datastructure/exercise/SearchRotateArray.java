package com.datastructure.exercise;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 */
public class SearchRotateArray {

	
	public static void main(String[] args) {
		SearchRotateArray test = new SearchRotateArray();
		System.out.println(test.minNumberInRotateArray(new int[]{2,2,2,2,0,1,1,1}));
	}
	
	public int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length == 0){
	    	return 0;
	    }
	    return search(0,array.length-1,array);
    }
	
	/**
	 * 根据题意可将数组分为[m][n]两个子数组，其中m数组的最小元素是大于等于n数组的最大元素的
	 * 1、如果a[start] < a[end],说明已经递增排好顺序了
	 * 2、如果a[start] = a[mid] = a[end],则进行顺序查找，因为计算不出中间的数属于前子数组还是后子数组
	 * 3、如果a[start] <= a[mid],说明a[mid]属于m数组，只需要在a[mid]->a[end]查找即可
	 * 4、如果a[start] > a[mid],说a[mid]属于n数组，只需要在a[start]->a[mid]查找即可
	 * 5、如果start + 1 = end,说明只剩下两个元素，直接取a[end]为最小元素，因为前面的数据>=后面的数据
	 */
	private int search(int start,int end,int[] a){
		while(a[start] >= a[end]){
			int mid = (start + end)/2;
			if(a[start] == a[mid] && a[mid] == a[end]){
				int min = a[start];
				for(int i = start;i<=end;i++){
					if(a[i] < min){
						min = a[i];
					}
				}
				return min;
			}
			if(a[start] <= a[mid]){
				start = mid;
			}else{
				end = mid;
			}
			if(start + 1 == end){
				return a[end];
			}
		}
		return a[start];
		
	}
	
}
