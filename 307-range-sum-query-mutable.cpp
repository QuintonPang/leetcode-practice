class NumArray {
public:
    vector<int> nums;
    vector<int> tree;
    NumArray(vector<int>& nums) {
        this->nums = nums;
        tree.resize(nums.size() + 1, 0);
        for(int i = 0;i < nums.size(); i++){
            add(i, nums[i]);
        }
    }

    void add(int index, int val){
          index++;
        while(index<tree.size()){
            tree[index] += val; 
            index += index & -index; 
        }
    }
    
    void update(int index, int newValue) {
          int difference = newValue - nums[index];

    nums[index] = newValue;

    add(index, difference);
      
    }
    
    int sumRange(int left, int right) {
    
        return prefixSum(right) - prefixSum(left - 1);
    }

    int prefixSum(int index){
        index++;
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */