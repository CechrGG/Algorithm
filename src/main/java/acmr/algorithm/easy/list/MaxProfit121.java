/**
 * 
 */
package acmr.algorithm.easy.list;

/**
 * @author guohz
 * @date 2020年9月22日
 * @description MaxProfit121
 * 
 * 	121.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

	如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	
	注意：你不能在买入股票前卖出股票。
	示例 1:
	
	输入: [7,1,5,3,6,4]
	输出: 5
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
	示例 2:
	
	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
	
	122.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

	设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
	
	注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	
	示例 1:
	
	输入: [7,1,5,3,6,4]
	输出: 7
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
	示例 2:
	
	输入: [1,2,3,4,5]
	输出: 4
	解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
	     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
	示例 3:
	
	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit121 {
	
	//先暴力解决再说
    public static int maxProfit(int[] prices) {
    	int max = 0;
    	for(int i = 0; i < prices.length - 1; i++) {
    		for(int j = i + 1; j < prices.length; j++) {
    			max = Math.max(max, prices[j] - prices[i]);
    		}
    	}
    	return max;
    }
    
    public static int maxProfit2(int[] prices) {
    	int min = Integer.MAX_VALUE;
    	int max = 0;
    	for(int i = 0; i < prices.length; i++) {
    		min = Math.min(min, prices[i]);
    		max = Math.max(max, prices[i] - min);
    	}
    	return max;
    }
    
    //122 取巧算法，不符合逻辑
    public static int maxProfit122(int[] prices) {
    	int max = 0;
    	for(int i = 1; i < prices.length; i++) {
    		if(prices[i] > prices[i -1]) {
    			max += prices[i] - prices[i - 1];
    		}
    	}
    	return max;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MaxProfit121.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(MaxProfit121.maxProfit(new int[] {7,6,4,3,1}));
		System.out.println(MaxProfit121.maxProfit2(new int[] {7,1,5,3,6,4}));
		System.out.println(MaxProfit121.maxProfit2(new int[] {7,6,4,3,1}));
		System.out.println(MaxProfit121.maxProfit122(new int[] {7,1,5,3,6,4}));
		System.out.println(MaxProfit121.maxProfit122(new int[] {7,6,4,3,1}));
		System.out.println(MaxProfit121.maxProfit122(new int[] {1,2,3,4,5}));
	}

}
