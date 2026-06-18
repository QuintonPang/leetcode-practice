class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m; // we can take from 0 up to m elements from nums1

        int totalLeft = (m+n +1)/2;

        while ( left<=right){
            int i = left + (right-left)/2;
            int j = totalLeft - i;

            int aLeft = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
            int aRight = (i==m) ? Integer.MAX_VALUE : nums1[i];

            int bLeft = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
            int bRight = (j==n) ? Integer.MAX_VALUE : nums2[j];

            if(aLeft<=bRight && aRight>=bLeft){
                if((m+n)%2==0) return (Math.max(aLeft,bLeft) + Math.min(bRight, aRight)) /2.0;
                else return Math.max(aLeft, bLeft);
            }else if(aLeft>bRight){
                right = i -1; // If we are too far right in nums1, move our search window left
            }else{
                left = i+1; // If we are too far left in nums1, move our search window right
            }

        }

        return 0.0;

    }
}