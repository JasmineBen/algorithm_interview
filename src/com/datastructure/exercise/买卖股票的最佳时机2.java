package com.datastructure.exercise;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */
public class 买卖股票的最佳时机2 {
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	/**
	 * 贪心算法
	 * 按照贪心策略，不关心以后，我们只关心当前利益。第0天买入，花费prices[0]，第一天卖出，得到prices[1]，那么我们的收获就是profit = prices[1] - prices[0],那么有两种情况
	 *（1）当profit > 0 时，赶紧买入卖出，能赚一笔是一笔，苍蝇再小也是肉嘛 
	 *（2）当profit <= 0 时，再买入卖出的话，那就是傻了，白费力气不说，还亏钱。
	 * 以此方式类推下去，即得最大利润。
	 * 
	 */
	public static int maxProfit(int[] prices) {
		if(prices != null && prices.length > 1) {
			int result = 0;
			for(int i = 1;i<prices.length;i++) {
				if(prices[i] > prices[i-1]) {
					/**
					 * 赶紧买入prices[i-1],卖出prices[i]
					 * 如果prices[i+1]大于prices[i]，说明在prices[i+1]卖的时候利润更大，
					 * 没关系，result += (prices[i] - prices[i-1])会将prices[i+1],prices[i]的差价补上
					 */
					result += (prices[i] - prices[i-1]);
				}
			}
			return result;
		}
		return 0;
	}
}
