/**
 * Created by Harry Chou at 2018/11/18.
 * Description: Say you have an array for which the ith element is the price of
 * a given stock on day i. If you were only permitted to complete at most one
 * transaction (i.e., buy one and sell one share of the stock), design an
 * algorithm to find the maximum profit. Note that you cannot sell a stock
 * before you buy one.
 */
public class SellStock {
    public int solution_1(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    result = Math.max(prices[j] - prices[i], result);
                }
            }
        }
        return result;
    }

    public int solution_2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            else if (price - min > result)
                result = price - min;
        }
        return result;
    }
}