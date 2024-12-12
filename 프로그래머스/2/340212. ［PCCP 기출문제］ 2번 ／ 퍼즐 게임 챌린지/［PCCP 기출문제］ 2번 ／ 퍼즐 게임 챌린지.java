class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1;
        int maxLevel = 100000;
        
        while (minLevel < maxLevel) {
            int mid = (minLevel + maxLevel) / 2;
            
            long totalTime = calculateTime(diffs, times, mid);
            
            if (totalTime <= limit) {
                maxLevel = mid;
            } else {
                minLevel = mid + 1;
            }
        }
        
        return minLevel;
    }
    
    private long calculateTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                totalTime += times[i];
            } else {
                totalTime += ((times[i - 1] + times[i]) * (diffs[i] - level) + times[i]);
            }
        }
        
        return totalTime;
    }
}