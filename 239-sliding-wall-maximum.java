class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] result = new int[nums.length-k+1];
        int currentLargestIndex = 0;
        Deque <Integer> q = new ArrayDeque<>();
        for(int i = 0 ;i<nums.length;i++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.offerLast(i);

            if(q.peekFirst() < i-k +1){ // remove index outside of window
                    q.pollFirst();
            }

            if(i>=k-1){ // start   
                    result[currentLargestIndex++] = nums[q.peekFirst()];
            }

        }

        return result;
    }
}