class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int rowSize  = matrix[0].length;
        int right = matrix.length * rowSize - 1;


        while(right>=left){
            int mid = left + (right-left) / 2;
            int row = mid / rowSize;
            int column = mid % rowSize;

            int number = matrix[row][column];

            if(number == target) return true;
            else{
                if (target > number) left = mid +1;
                else right = mid - 1;
            }
        }
        return false;
    }
}