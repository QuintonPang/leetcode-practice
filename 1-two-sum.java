class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> lookups = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            int complement = target - nums[i];
            if(lookups.containsKey(complement)){
                return new int[]{lookups.get(complement), i};
            }else{
                lookups.put(nums[i],i);
            }
        }
    return new int[]{};

    }

}