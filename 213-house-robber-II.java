class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int excludeStart =
        robRange(nums,1,nums.length-1)
   ;
   int excludeLast = robRange(nums,0,nums.length-2);
   
   return Math.max(excludeStart,excludeLast);
    }
    
    int robRange(int[]nums, int start, int end){
        int prevOne = 0;
        int prevTwo = 0; 
        for(int i=start;i<=end;i++){
            int current = nums[i] + prevTwo;
            int bestCurrent = Math.max(current, prevOne );
            prevTwo = prevOne;
            prevOne = bestCurrent;
            
        }
        
        return prevOne;
    }
}