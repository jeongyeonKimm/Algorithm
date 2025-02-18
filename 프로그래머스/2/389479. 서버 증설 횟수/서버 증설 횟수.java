import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int size = 0;   // 현재 서버 개수
        int count = 0;  // 서버 증설 횟수
        
        for (int i = 0; i < 24; i++) {
            if (!pq.isEmpty() && pq.peek()[0] == i) {
                size -= pq.poll()[1];
            }
            
            int current = players[i] / m;  // 현재 시각 필요한 서버의 개수
            int need = current - size;  // 현재 있는 서버에서 추가로 필요한 서버의 개수
            
            if (need > 0) {
                size += need;
                count += need;
                pq.offer(new int[] {i + k, need});  // 만료시간, 추가로 증설된 서버의 개수
            }
        }
        
        return count;
    }
}