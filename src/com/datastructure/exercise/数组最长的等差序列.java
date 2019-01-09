package com.datastructure.exercise;

/**
 * ��������������ɵ��������ҵ����ȴ���=3����ĵȲ�����
 * ����[1,3,0,5,-1,6]
 * ���[-1,1,3,5]
 * ע�⣺����һ��Ҫ���������Ԫ��˳������ֻ�����������ݵģ�û���Ⱥ��ϵ
 */
public class ������ĵȲ����� {
	
	public static void main(String[] args) {
		int[] a = new int[]{2,3,0,4,-2,6};
		������ĵȲ����� test = new ������ĵȲ�����();
		test.sulution(a);
	}

	/**
	 * ��һ����һ����������
	 * �ڶ�������̬�滮����һ�����ź���������У��Ȳ����еĲ�d���� 0 <= d <= a[N-1] - a[0]��
	 * ���ǣ���һ����ά��dp����a[N-1] - a[0] + 1 �У�N�У�
	 * dp[i][j]��¼����a[j]������Ϊi�µ�����г��ȡ�
	 * ��ô�������У�dp[i][j] = dp[i][index_of(a[j] + i )] + 1��
	 * ����index_of(num)��ʾ��num������a�е�������
	 * ����dp����˼�ǣ����a[j]�ܹ��ɵȲ����е�һ���ӣ�����Ϊi��
	 * ��ô������һ�����a[j] + i���⵱ȻҪ��a[j] + i����������a����~���ң�
	 * a[j]���ɵ����еĳ��Ⱦ����� a[j] + i �������г��ȼ�1. 
	 * ��������������ֻҪ������a��β��ͷ��������ÿ��a[j]��
	 * ������й����0��a[N-1]-a[0]�µ�����г��ȣ�������͵ý��ˡ�
	 * 
	 * ע�⼸�����⣺
	 * 1. ��������������Ҫ��������й����0��a[N-1]-a[0]����ʵ���ϲ�����Ҫ��ôһ��һ������
	 * ��Ϊ���κ�a[j]�����ܹ��ɵȲ����У��򹫲�һ���� a[k]-a[j]������ j < k < N��
	 * ��ˣ����ķ�Χ�õ���С����������ʱ�临�Ӷ�Ϊ0(N^2)��
	 * 2. ��һ��ʵ�������ǣ�dpֻ��¼������еĳ��ȣ�������Ϊ���ܻ�˷������Ȳ����У�
	 * ���ǻ���Ҫ֪��������Ȳ�����a[j]����һ������ʲô����ˣ���Ҫͬʱ��¼��һ����������
	 * �ڴ����У���Pair����¼��length��ʾ����,next��ʾ��һ����
	 * 3. ע�⴦��a[j]��������ֵ��ͬ����������� 1,3,3����a[0]=1��
	 * ����a[1]��a[2]�Ĳ�ֵ��ͬ�����Զ���a[0]������Ϊ2���ԣ���dp[2][0]����ֻ��Ҫ����һ�μ��ɡ�
	 */
	public int[] sulution(int[] a) {
		����.quickSort(a);
	
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
		int rowidx = -1;//���Ȳ����е��кţ����
		int colidx = -1;//���Ȳ����е��к�

		for (int j = len - 2; j >= 0; --j) {
			//��a[k]��β�ĵȲ�����
			for (int k = j + 1; k < len; ++k) {
				int tolerance = a[k] - a[j];// ����
				//��a[k]��β�Ĺ���Ϊtolerance�ĵȲ�����
				if (dp[tolerance][j].length != 0) {
					continue; // �Ըá��Ϊ�кŵ�ֵ����Ѿ����ڣ��Ͳ���Ҫ��Ϊ��ͬ�Ĳ�ֵ����
				}
				// dp[i][j] = dp[i][index_of(a[j]+i)] + 1
				// ���a[j]�ܹ��ɵȲ����е�һ���ӣ�����Ϊi����ô������һ�����a[j] + i
				// a[k]...a[j],��a[j]��β����������toleranceΪ����ĳ���==��a[k]��β����������toleranceΪ����ĳ���+1
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
