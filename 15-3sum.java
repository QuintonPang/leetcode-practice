class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 
        Arrays.sort(nums);
        List<List <Integer> > ans = new ArrayList<>();
        for(int i =0; i< nums.length-2; i++){

            if(i!= 0 && nums[i-1]==nums[i]) continue;

            int j = nums.length - 1;
            int k = i+1;
            while (k<j){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    do{
                        k++;
                    }while(nums[k-1]== nums[k] && j>k);
                      do{
                        j--;
                    }while(nums[j+1]== nums[j] && j>i);
                    }else if(sum<0){
                        do{
                        k++;
                    }while(nums[k-1]== nums[k]&& j>k);
                    }else if(sum>0){
                       do{
                        j--;
                    }while(nums[j+1]== nums[j]&& j>i );
                    }
                // k+=1;

            }


        }

        return ans;
    }
}