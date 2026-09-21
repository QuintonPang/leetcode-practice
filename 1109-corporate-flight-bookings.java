class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] changes = new int[n+1];
        for(int i = 0 ; i<bookings.length; i++ ){
                changes[bookings[i][0]-1] += bookings[i][2];
                changes[bookings[i][1] ]  -= bookings[i][2];
        }

        int current = 0;
        int[] answer = new int[n];
        for(int i = 0;i<changes.length-1;i++){
            current += changes[i];
            answer[i] = (current);
        }

        return answer;
    }
}
