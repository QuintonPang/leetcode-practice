class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length<=0) return 0;

        int i = 1;

        int j = 1;


        while(j<nums.length){
            if(nums[i-1]!=nums[j]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}