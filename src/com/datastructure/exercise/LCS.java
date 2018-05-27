package com.datastructure.exercise;

/**
 * 最长公共子序列（Longest-Common-Subsequence，LCS）
 * 最长公共子序列就是寻找两个给定序列的子序列，该子序列在两个序列中以相同的顺序出现，但是不必要是连续的。
 * 例如序列X=ABCBDAB，Y=BDCABA。序列BCA是X和Y的一个公共子序列，
 * 但是不是X和Y的最长公共子序列，子序列BCBA是X和Y的一个LCS，序列BDAB也是。
 */
public class LCS {
	
	/**
	 * i,j分别表示x和y的序列长度
	 * dp[i][j] = 0  如果i=0或j=0
	 * dp[i][j] = dp[i-1][j-1] + 1  如果X[i-1] = Y[i-1]
	 * dp[i][j] = max{ dp[i-1][j], dp[i][j-1] } 如果X[i-1] != Y[i-1]
	 */
	private int[][] dp;
	
	public static void main(String[] args) {
		String x = "ABCBDAB";
		String y = "BDCABA";
		LCS test = new LCS();
		System.out.println(test.lcs(x,y));
	}

	/**
	 * 使用动态规划求解这个问题，先寻找最优子结构。
	 * 设X=<x1,x2,…,xm>和Y=<y1,y2,…,yn>为两个序列，LCS(X,Y)表示X和Y的一个最长公共子序列，可以看出
	 * 如果xm=yn，则LCS ( X,Y ) = xm + LCS ( Xm-1,Yn-1 )。
	 * 如果xm!=yn，则LCS( X,Y )= max{ LCS ( Xm-1, Y ), LCS ( X, Yn-1 ) }
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
	 * dp[i][j]表示以x[i],y[j]结束的子串的最长公共子序列长度
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
