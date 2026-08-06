class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int i = 0; i<nums.length;i++){
            totalSum += nums[i];
        }
        
        if(Math.abs(target)>totalSum){
            return 0;
        }
        
        if((totalSum+target)%2==1) return 0;
        
        int subsetTarget = (totalSum+target) / 2;
        
        int [] dp = new int[subsetTarget+1];
      
       dp[0] = 1;
       for(int num: nums)
        for(int i=subsetTarget;i>=num;i--){
            dp[i] += dp[i-num];
        }
        return dp[subsetTarget];
    }
    
}