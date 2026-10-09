class Solution {
public:
    vector<int> tree;

    void add(int index, int value) {
        while (index < tree.size()) {
            tree[index] += value;
            index += index & -index;
        }
    }
    int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> sorted = nums;

        sort(sorted.begin(), sorted.end());

        sorted.erase(
            unique(sorted.begin(), sorted.end()),
            sorted.end()
        );

        tree.resize(sorted.size() + 1, 0);

        vector<int> answer(nums.size());

        for (int i = nums.size() - 1; i >= 0; i--) {

            int rank =
                lower_bound(
                    sorted.begin(),
                    sorted.end(),
                    nums[i]
                ) - sorted.begin() + 1;

            answer[i] = prefixSum(rank - 1);

            add(rank, 1);
        }

        return answer;
    }
};