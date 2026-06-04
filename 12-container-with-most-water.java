class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1 ;

        while (right>left){
            int h = Math.min(height[right] , height[left]);
            int area = h * (right - left) ;
            max = Math.max(area, max);

            if(height[right] > height[left]) left++;
            else right--;
        }
        return max;
    }
}