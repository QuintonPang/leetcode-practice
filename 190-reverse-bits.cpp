class Solution {
public:
    int reverseBits(int n) {
        unsigned int answer = 0;
        unsigned int bits = static_cast<unsigned int>(n);

        for(int i = 0; i< 32; i++){
            int last  = bits & 1;

             answer <<= 1;
                         answer |= last;

             bits >>= 1;
        }

        return answer;
    }
};