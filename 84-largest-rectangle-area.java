class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer>  hStack = new Stack<>();
        int maxArea = 0;
            for(int i = 0; i<= heights.length; i++){
                int height = i == heights.length ? 0 : heights[i];

                while(!hStack.isEmpty()&&height< heights[hStack.peek()]){
                        int currIndex = hStack.pop();
                        int h = heights[currIndex];
                        
int width = hStack.isEmpty() ? i : i - hStack.peek() - 1;          // hStack peek is left boundary , if hstack is empty, it means it spans across the whole graph  
             int area = width * h; 
                        maxArea = Math.max(area, maxArea);
                }

                hStack.push(i);
            }

            return maxArea;
    }
}