class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = 0;
        int p = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int cnt = 0;
                
                while (d < deliveries[i] || p < pickups[i]) {
                    cnt++;
                    d += cap;
                    p += cap;
                }
                
                d -= deliveries[i];
                p -= pickups[i];
                answer += (i + 1) * cnt * 2;
            }
        }
        
        return answer;
    }
}