class Solution {
    public int maxCoins(int[] nums) {
        int[]  values = new int[nums.length+2];
        
        values[0] = 1;
        values[values.length-1] = 1;
        
        for(int i = 0;i<nums.length;i++){
            values[i+1] = nums[i];
        }
        
        int [][] dp = new int[nums.length+2][nums.length+2];
        
        for(int length =2; length< nums.length+2;length++){
            for(int left = 0; left + length < nums.length+2;left++){
                int right = left + length;
                for(int i = left +1; i < right; i++){
                    int coins = dp[left][i] + values[left] * values[i] *values[right] + dp[i][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        return dp[0][nums.length+1];
    }
}