class Solution {
public:
    bool isPowerOfFour(int n) {

        // 1 integer = 32 bits
        // 0101 0101 0101 0101 0101 0101 0101 0101
        int x = 0x55555555;

        
        return n <= 0 ? false: (((n & (n-1)) == 0 ) && ( (n & x) == n)) ;

    }
};