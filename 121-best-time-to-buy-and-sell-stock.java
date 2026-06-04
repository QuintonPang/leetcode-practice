class Solution {
    public int maxProfit(int[] prices) {
     

        int min = prices[0];
        int profit = 0;
        for(int price: prices){
            min = Math.min(price,min);
            profit = Math.max(profit, price - min);
        }

        return profit;
    }
}