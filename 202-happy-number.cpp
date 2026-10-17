class Solution {
public:
    bool isHappy(int n) {
          unordered_set<int> seen;

        while(true){
                        if(n==1) return true;

                int current = 0;
            while(n>0){
                current += (n%10)*(n%10) ;
                n /= 10;
            }
            cout<< current<<endl;
            n = current;
                         if(seen.count(n)) break;

            seen.insert(n);
        }
       

        return false;
    }
};