class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 
      
      Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i<nums.length-2 && nums[i]<=0;i++){
            if(i != 0 && nums[i]==nums[i-1]) continue;

            int complement = 0 - nums[i]; 

            int left = i + 1, right = nums.length-1;
            while(right > left){
                int sum = nums[right] + nums[left];
                if(sum == complement){ 
                    ans.add(Arrays.asList(new Integer[]{nums[left], nums[right], nums[i]}));
                    left++;
                    while( right>left &&nums[left] == nums[left-1] ){
                        left++;
                    }
                    right--;
                     while( right >left && nums[right] == nums[right+1] ){
                        right--;
                    }
                    }
                else{
                    if(sum>complement){
                        right--;
                    }else{
                        left++;
                    }
                }
            }

        }

        return ans;
    }
}