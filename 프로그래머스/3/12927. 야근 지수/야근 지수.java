import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.offer(w);
        }
        
        while (n > 0) {
            int cur = pq.poll();
            if (cur <= 0) break;
            cur--;
            pq.offer(cur);
            n--;
        }
        
        long result = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            result += (num * num);
        }
        return result;
    }
}