class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1, post = 1;
        int [] ans  = new int[nums.length];
        Arrays.fill(ans,0);
        for (int i=0;i<nums.length;i++){
            ans[i] = pre;
            pre *= nums[i];
        }

         for (int j=nums.length-1;j>=0;j--){
            ans[j] = ans[j] * post;
            post *= nums[j];
        }

        return ans;
    }
}