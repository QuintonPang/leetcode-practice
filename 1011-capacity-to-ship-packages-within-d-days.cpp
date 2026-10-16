class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int smallest = *max_element(weights.begin(), weights.end());
        int largest = accumulate(weights.begin(),weights.end(),0 );

        while(smallest<largest){
            int daysNeeded = 1;
            int current = 0;
            int mid = smallest + (largest-smallest)/2;
            for(auto& weight: weights){
                if(weight+current<=mid){
                    current+=weight;
                }else{
                    daysNeeded ++;
                    current = weight;
                }
            }

            if ( daysNeeded <= days){
                largest = mid;

            }else{
                smallest = mid +1;
            }
        }

        return smallest;
    }
};