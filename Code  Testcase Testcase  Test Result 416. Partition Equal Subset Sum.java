class Solution {
    public boolean canPartition(int[] nums) {


            int sum = 0 ;
            for(int i = 0;i<nums.length;i++){
                sum += nums[i];
            }

            boolean isOdd = sum % 2 == 0 ? false: true;

            if(isOdd) return false;

            int target = sum / 2;

        boolean[] dp = new boolean[target+1];

        dp[0] = true;

        for(int num : nums){
            for (int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }

        return dp[target];
    }

}
