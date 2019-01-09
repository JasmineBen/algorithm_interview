package com.datastructure.exercise;

/**
 * 求整数随机数构成的数组中找到长度大于=3的最长的等差数列
 * 输入[1,3,0,5,-1,6]
 * 输出[-1,1,3,5]
 * 注意：并不一定要按照数组的元素顺序，数组只是用来存数据的，没有先后关系
 */
public class 数组最长的等差序列 {
	
	public static void main(String[] args) {
		int[] a = new int[]{2,3,0,4,-2,6};
		数组最长的等差序列 test = new 数组最长的等差序列();
		test.sulution(a);
	}

	/**
	 * 第一步都一样，先排序。
	 * 第二步，动态规划。在一个已排好序的数列中，等差数列的差d满足 0 <= d <= a[N-1] - a[0]。
	 * 于是，设一个二维表dp，有a[N-1] - a[0] + 1 行，N列，
	 * dp[i][j]记录数列a[j]，公差为i下的最长数列长度。
	 * 那么很明显有：dp[i][j] = dp[i][index_of(a[j] + i )] + 1。
	 * 其中index_of(num)表示数num在数组a中的索引。
	 * 上述dp的意思是：如果a[j]能构成等差数列的一份子，公差为i，
	 * 那么它的下一项就是a[j] + i，这当然要求a[j] + i存在于数组a中啦~而且，
	 * a[j]构成的数列的长度就是由 a[j] + i 构成数列长度加1. 
	 * 依据上述分析，只要对数组a由尾到头遍历，对每个a[j]，
	 * 求出所有公差从0到a[N-1]-a[0]下的最长数列长度，则问题就得解了。
	 * 
	 * 注意几个问题：
	 * 1. 上述分析过程中要求求出所有公差从0到a[N-1]-a[0]，但实际上并不需要这么一个一个的求，
	 * 因为以任何a[j]，它能构成等差数列，则公差一定是 a[k]-a[j]，这里 j < k < N，
	 * 因此，求解的范围得到缩小，因此整体的时间复杂度为0(N^2)。
	 * 2. 另一个实现问题是，dp只记录了最长数列的长度，而我们为了能回朔并输出等差数列，
	 * 我们还需要知道构成最长等差数列a[j]的下一个数是什么，因此，需要同时记录下一跳的索引。
	 * 在代码中，用Pair来记录，length表示长度,next表示下一跳。
	 * 3. 注意处理a[j]与多个数差值相同的情况，比如 1,3,3，对a[0]=1，
	 * 它和a[1]，a[2]的差值相同，所以对于a[0]，公差为2而言，即dp[2][0]，它只需要更新一次即可。
	 */
	public int[] sulution(int[] a) {
		排序.quickSort(a);
	
		int len = a.length;
		int R = a[len - 1] - a[0] + 1;
		Pair[][] dp = new Pair[R][len];
		for (int i = 0; i < R; i++) {
			Pair[] pair = new Pair[len];
			for (int j = 0; j < len; j++) {
				pair[j] = new Pair();
			}
			dp[i] = pair;
		}
		int maxlen = 0;
		int rowidx = -1;//最大等差数列的行号（公差）
		int colidx = -1;//最大等差数列的列号

		for (int j = len - 2; j >= 0; --j) {
			//以a[k]结尾的等差数列
			for (int k = j + 1; k < len; ++k) {
				int tolerance = a[k] - a[j];// 公差
				//以a[k]结尾的公差为tolerance的等差数列
				if (dp[tolerance][j].length != 0) {
					continue; // 以该“差”为行号的值如果已经存在，就不需要再为相同的差值更新
				}
				// dp[i][j] = dp[i][index_of(a[j]+i)] + 1
				// 如果a[j]能构成等差数列的一份子，公差为i，那么它的下一项就是a[j] + i
				// a[k]...a[j],以a[j]结尾的子序列以tolerance为公差的长度==以a[k]结尾的子序列以tolerance为公差的长度+1
				//k > j
				dp[tolerance][j].length = dp[tolerance][k].length + 1;
				dp[tolerance][j].next = k;

				if (dp[tolerance][j].length > maxlen) {
					maxlen = dp[tolerance][j].length;
					rowidx = tolerance;
					colidx = j;
				}
			}
		}
		System.out.println("maxlen:"+maxlen+";rowidx:"+rowidx+";colidx:"+colidx);
		if (maxlen > 1) {
			while (colidx != -1) {
				System.out.print(a[colidx] + ";");
				colidx = dp[rowidx][colidx].next;
			}
		}
		return null;
	}
	
	class Pair{
		int length;
		int next;
		
		public Pair(){
			length = 0;
			next = -1;
		}
	}
	
}
