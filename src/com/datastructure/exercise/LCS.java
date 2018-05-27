package com.datastructure.exercise;

/**
 * ����������У�Longest-Common-Subsequence��LCS��
 * ����������о���Ѱ�������������е������У�������������������������ͬ��˳����֣����ǲ���Ҫ�������ġ�
 * ��������X=ABCBDAB��Y=BDCABA������BCA��X��Y��һ�����������У�
 * ���ǲ���X��Y������������У�������BCBA��X��Y��һ��LCS������BDABҲ�ǡ�
 */
public class LCS {
	
	/**
	 * i,j�ֱ��ʾx��y�����г���
	 * dp[i][j] = 0  ���i=0��j=0
	 * dp[i][j] = dp[i-1][j-1] + 1  ���X[i-1] = Y[i-1]
	 * dp[i][j] = max{ dp[i-1][j], dp[i][j-1] } ���X[i-1] != Y[i-1]
	 */
	private int[][] dp;
	
	public static void main(String[] args) {
		String x = "ABCBDAB";
		String y = "BDCABA";
		LCS test = new LCS();
		System.out.println(test.lcs(x,y));
	}

	/**
	 * ʹ�ö�̬�滮���������⣬��Ѱ�������ӽṹ��
	 * ��X=<x1,x2,��,xm>��Y=<y1,y2,��,yn>Ϊ�������У�LCS(X,Y)��ʾX��Y��һ������������У����Կ���
	 * ���xm=yn����LCS ( X,Y ) = xm + LCS ( Xm-1,Yn-1 )��
	 * ���xm!=yn����LCS( X,Y )= max{ LCS ( Xm-1, Y ), LCS ( X, Yn-1 ) }
	 * @return
	 */
	public String lcs(String x,String y){
		if(dp == null){
			dp = new int[x.length()+1][y.length()+1];
			for(int i = 0;i<=x.length();i++){
				for(int j=0;j<=y.length();j++){
					dp[i][j] = 0;
				}
			}
		}
		dp(x,y);
		System.out.println(dp[x.length()][y.length()]);
		return print(x, y);
	}
	
	/**
	 * dp[i][j]��ʾ��x[i],y[j]�������Ӵ�������������г���
	 * @param x
	 * @param y
	 */
	public void dp(String x,String y){
		for(int i = 1;i<=x.length();i++){
			for(int j = 1;j<=y.length();j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
	}
	
	private String print(String x,String y){
		int size = dp[x.length()][y.length()];
		char[] result = new char[size];
		int i = x.length();
		int j = y.length();
		while(i > 0 && j > 0){
			if(dp[i][j] == dp[i-1][j-1]+1){
				result[--size] = x.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
		return new String(result);
	}
}
