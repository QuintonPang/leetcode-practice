class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int one = m-1;
        int two = n-1;
        int last = m+n-1;
       
        while(two >=0){
            if(one < 0 || nums1[one]<nums2[two]){
                nums1[last] = nums2[two];
                two -- ;
               
            }else{
                nums1[last] = nums1[one];
                one --;
                
            }

            last--;
        }

    }
};