class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = 0;  // 한번 이동할 때 배달 가능한 상자의 최대 개수
        int p = 0;  // 한번 이동할 때 수거 가능한 상자의 최대 개수
        
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int cnt = 0;    // i번째 집을 방문하는 횟수
                
                while (d < deliveries[i] || p < pickups[i]) {
                    cnt++;
                    d += cap;   // 한번 이동할 때 배달 및 수거는 최대 cap 만큼 가능
                    p += cap;
                }
                
                // 현재 집까지 이동하는데 배달 및 수거 가능한 상자의 개수 범위 내에서 물류센터로 다시 이동하지 않고 배달 및 수거 가능한 상자의 개수 차감
                d -= deliveries[i];
                p -= pickups[i];
                answer += (i + 1) * cnt * 2;
            }
        }
        
        return answer;
    }
}