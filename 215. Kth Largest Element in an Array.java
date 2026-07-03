import java.util.Random;
class Solution {
            Random random = new Random();

    public int findKthLargest(int[] nums, int k) {

        // target index
        int target = nums.length - k;

        int left = 0;
        int right = nums.length -1;

        while(left <= right){
int[] range = partition(nums, left, right);            if (target >= range[0] && target <= range[1]) {
    return nums[target];
} else if (target < range[0]) {
    right = range[0] - 1;
} else {
    left = range[1] + 1;
} 
        }

        return -1;
    }

    int[] partition(int[] nums, int left, int right) {
    int randomIndex = left + random.nextInt(right - left + 1);
    int pivot = nums[randomIndex];

    int less = left;
    int i = left;
    int greater = right;

    while (i <= greater) {
        if (nums[i] < pivot) {
            swap(nums, less, i);
            less++;
            i++;
        } else if (nums[i] > pivot) {
            swap(nums, i, greater);
            greater--;
        } else {
            i++;
        }
    }

    return new int[]{less, greater};
}

    void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
