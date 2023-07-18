class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0, start = 0, end = 0, prevEnd;

        for (int i = 0; i < timeSeries.length; i++) {
            start = timeSeries[i];

            if (i == 0) {
                prevEnd = 0;
            } else {
                prevEnd = end;
            }

            end = timeSeries[i] + duration - 1;
            time += duration;

            if (i != 0 && timeSeries[i] <= prevEnd) {
                time -= (prevEnd - start) + 1;
            }
        }
        
        return time;
    }
}
