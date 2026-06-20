class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do{
            fast =nums[nums[fast] ];
            slow = nums[slow];
        }while(slow!=fast);

        slow = 0;

         do{
            fast = nums[fast] ;
            slow = nums[slow];
        }while(slow!=fast);

        return slow;
    }
}