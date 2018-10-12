/**
 * Created by Harry Chou at 2018/10/12 
 * Description: Say you have an array for which the ith element is the price of
 * a given stock on day i. Design an algorithm to find the maximum profit. You
 * may complete as many transactions as you like (i.e., buy one and sell one
 * share of the stock multiple times).
 */
public class maxProfit {
    public int calc(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0)
                sum += prices[i + 1] - prices[i];
        }
        return sum;
    }
}
