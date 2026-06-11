class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
            Stack <Integer> indices = new Stack<>();

            int [] ans = new int[temperatures.length];
            for(int i = 0;i<temperatures.length;i++){
                int t = temperatures[i];
                while( !indices.isEmpty() && t>temperatures[indices.peek()] ){
                    ans[indices.peek()] =  i - indices.peek();
                    indices.pop();
                }

                indices.push(i);
            }

            return ans;
    }
}