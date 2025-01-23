class Solution {
    public int solution(int n, int[] stations, int w) {
        int idx = 0;
        int cur = 1;
        int count = 0;
        
        while (cur <= n) {
            if (idx >= stations.length || stations[idx] - w > cur) {
                count++;
                cur += (2 * w + 1);
            } else {
                cur = stations[idx] + w + 1;
                idx++;
            }
        }
        
        return count;
    }
}