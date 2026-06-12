class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double [] [] cars = new double[position.length][2];

        for(int i = 0; i< position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i]) / speed[i];
        }

        // descending by position
        Arrays.sort(cars,(a, b) -> Double.compare(b[0],a[0]));

        double currentLongestTime = 0;
        int fleet = 0;
        for(double []c : cars){
            if(c[1]>currentLongestTime) { // new fleet only if it does not catch up to the leading car
                currentLongestTime = c[1];
                fleet ++ ;
             }
        } 

        return fleet;
    }
}