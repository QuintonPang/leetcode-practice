class Solution {
    public int maxProfit(int[] prices) {
       int hold = -prices[0];
        int sold = 0;
       int rest = 0;

       for(int i = 1; i<prices.length;i++){
            int currentHold = hold;
            int currentRest = rest;
            int currentSold = sold;

            // continue holding OR buy after rest
            hold = Math.max(hold, currentRest - prices[i]);
            
            // sell now
            sold = currentHold + prices[i];

            // continue resting OR sell and rest
            rest = Math.max(rest, currentSold);

       }

       // cannot be hold, can only be either sold or at rest
       return Math.max(sold, rest);
    }
}
