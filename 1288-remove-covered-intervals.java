class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int[] current = intervals[0];
        int covered = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][1]) {
                covered++;
            } else {
                current = intervals[i];
            }
        }

        return intervals.length - covered;
    }
}
