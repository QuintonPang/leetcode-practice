class Solution {
    public int rob(int[] nums) {
        int oneHouseBefore = nums[0];
        int twoHouseBefore = 0;
        
        for(int i =1;i<nums.length;i++){
            int current = Math.max(twoHouseBefore+nums[i], oneHouseBefore);
            twoHouseBefore = oneHouseBefore;
            oneHouseBefore = current;
            
        }
        return oneHouseBefore;
    }
}