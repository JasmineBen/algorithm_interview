package com.datastructure.exercise;

/**
 * 排序
 */
public class 排序 {
	
	public static void main(String[] args) {
		int[] a = new int[]{5,3,6,2,7,1,4,0,9,8};
//		int[] a = new int[]{1,2,3,4,5,6,7,8,9};
//		quickSort(a);
//		bubbleSort(a);
		//selectSort(a);
//		insertSort(a);
		mergeSort(a);
//		heapSort(a);
		for(int i : a){
			System.out.println(i);
		}
	}
	
	
	/**
	 * 冒泡排序
	 * 被排序的数组垂直排列a[0-n],轻气泡不能再重气泡之下
	 * 第一次排序将a[0]到a[n]两两对比，如果a[i]>a[i+1],那么就交换,结束后最大的元素就在a[n]位置
	 * 第二次排序将a[0]到a[n-1]两两对比如果a[i]>a[i+1],那么就交换，结束后最大的元素就在a[n-1]位置
	 * 以此类推：最后一次将a[0]与a[1]对比，大的数赋值给a[1]
	 * 
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j] < a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 第一次排序，将a[1]到a[n]的元素和a[0]对比，如果比a[0]小就和a[0]交换，一次排序下来a[0]就是最小值
	 * 第二次排序，将a[2]到a[n]的元素和a[1]对比，将较小的值给a[1],一次排序下来a[1]就是最小值
	 * 以此类推，最后以此将a[n-1]和a[n]对比，如果a[n-1]>a[n]就交换两个的值
	 * @param a
	 */
	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	
	/**
	 * 插入排序
	 * 从第一个元素开始，被认定为有序的
	 * a[0],a[1]....a[i-1],a[i],...a[n]
	 * a[0]到a[i]已经是有序的，for(int j=i-1,j>=0;j--),
	 * 如果a[j]>a[i],则a[j]-a[i-1]都向后移动，
	 * 如果a[j]<a[i]则循环结束
	 * @param a
	 */
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j;
			for (j = i - 1; j >= 0 && tmp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j+1] = tmp;

		}
	}
	
	/**
	 * 归并排序
	 * @param a
	 */
	public static void mergeSort(int[] a){
		int[] tmp = new int[a.length];
		mergeSort(a, 0, a.length-1, tmp);
	}
	
	private static void mergeSort(int[] a, int first,int last, int[] tmp) {
		if(first < last){
			int mid = (first+last)/2;
			mergeSort(a, first, mid, tmp);
			mergeSort(a, mid+1, last, tmp);
			merge(a, first, mid, last, tmp);
		}
		
	}
	
	/**
	 * 将两个有序数组a[first...mid],a[mid+1...last]合并
	 * @param a
	 * @param first
	 * @param mid
	 * @param last
	 * @param tmp
	 */
	private static void merge(int[] a, int first, int mid, int last, int[] tmp) {
		int i = first, j = mid + 1;
		int k = 0;
		while (i <= mid && j <= last) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}

		while (i <= mid) {
			tmp[k++] = a[i++];
		}

		while (j < a.length) {
			tmp[k++] = a[j++];
		}

		for (i = 0; i < k; i++) {//拷贝到原数组
			a[first + i] = tmp[i];
		}
	}
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}
	
	
	private static void quickSort(int[] a,int start,int end){
		if(start >= end){
			return;
		}
		int partition = partition(a, start, end);
		quickSort(a, start, partition-1);
		quickSort(a, partition + 1, end);
	}
	
	/**
	 * 一趟快速排序的算法是：
	 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
	 * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
	 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
	 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
	 * 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
	 * 使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。
	 * 另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
	 */
	private static int partition(int[] a, int start, int end) {
		int key = a[start];
		while (start < end) {//扫描顺序不能错
			while(a[end] >= key && start < end){//从后往前扫描
				end -- ;
			}
			a[start] = a[end];
			
			while(a[start] <= key && start < end){//从前往后扫描
				start ++;
			}
			a[end] = a[start];			
		}
		a[end] = key;
		return end;
	}
	
	/**
	 * 大根堆：根节点的值大于左右子树,并且是完全二叉树。
	 * 如果按照层次遍历二叉树得到数组arr,那么a[i]>=a[2i+1] 且 a[i]>=a[2i+2]。
	 * 实现堆排序首先是建堆：从非叶子节点开始，从小而上，从右到左调整
	 */
	public static void heapSort(int[] arr){
		if(arr != null){
			//建堆
			for(int i = arr.length/2-1;i>=0;i--){
				adjustHeap(arr, i, arr.length);
			}
			
			//调整堆，交换对顶元素和末尾元素
			for(int i=arr.length-1;i>=0;i--){
				swap(arr, 0, i);//交换堆顶和末尾元素
				//交换完成后需要调整堆
				adjustHeap(arr, 0, i);
			}
			
		}
	}
	
	//调整堆，
	private static void adjustHeap(int[] arr, int i, int len) {
		int tmp = arr[i];
		/**
		 * 从i的左孩子开始，也就是2i+1,开始向小调整，如果a[i]小于左节点a[2i+1]或者右节点a[2i+2]，
		 * 那么就交换a[i]和max(a[2i+1],a[2i+2]),假设和a[2i+1]交换了，
		 * 那么以a[2i+1]为根的左子树可能失去平衡，需要继续调整a[2i+1]的子树a[2(2i+1)+1],a[2(2i+1)+2]
		 */
		for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
			if(j+1<len &&arr[j] < arr[j+1]){//a[2i+1]<a[2i+2],a[i]和a[2i+2交换]
				j++;
			}
			if(tmp < arr[j]){
				arr[i] = arr[j];//交换a[i]和max(a[2i+1],a[2i+2])
				i = j;
			}else{
				break;
			}
		}
		arr[i] = tmp;

	}
	
	
	//交换数组a的两个位置的元素
	private static void swap(int[] a,int indexA,int indexB){
		int temp = a[indexA];
		a[indexA] = a[indexB];
		a[indexB] = temp;
	}

}
