class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int water = 0;

        while(left<right){
            if(height[left]<height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left] ;

                left++;
            }else{
                 maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right] ;

                right--;
            }
        }

        return water;
    }
}